package de.schmitzekater


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserIntegrationSpec extends Specification {


    def "Create simple User for the database"(){
        given: "First new User"
        def hansPerson = new Person(firstName: "Hans", lastName: "Albers", email: "hans.albers@beruehmte-saenger.de").save(failOnError: true)
       // def hansPerson = Mock(Person).save(failOnError: true)
        def hans = new User(username: 'hansat', password: 'secret', signature: 'signature', isAdmin: false, isReadOnly: false,
                person:  hansPerson)
        hans.lastPasswordChange = new Date()

        when: "User is saved"
        hans.save(failOnError: true)

        then: "The user is saved and can be found"
        hans.errors.errorCount == 0
        hans.id != null
        User.get(hans.id).username == hans.username
    }

    def "Make sure all fields are set"(){
        given: "A User with an unset field"
        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com").save(failOnError: true)
        def peter = new User(username: "peters", password: "geheim", signature: "signature", isReadOnly: false,  lastPasswordChange: new Date(), person: peterPerson)

        when: "Peter is saved"
        peter.save()

        then: "Peter was saved and is no Admin"
        peter.isAdmin == null
        User.get(peter.id).password == 'geheim'
    }
    @Ignore
    def "Change password of a user is no problem"(){
        given: "Peter is given again"
        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com").save(failOnError: true)
        def peter = new User(username: "peters", password: "geheim", signature: "signature", isReadOnly: false,  lastPasswordChange: new Date(), person: peterPerson)
        peter.save()
        when: "Password is changed"
        def savedPeter = User.get(peter.id)
        savedPeter.changePassword("geheim", "vielgeheimer")
        savedPeter.save(failOnError: true)

        then: "Peters password is changed"
        User.get(savedPeter.id).password =="vielgeheimer"
        User.get(savedPeter.id).lastPasswordChange != peter.dateCreated
        User.get(savedPeter.id).person.lastName == "Parker"
    }
    def "Now we have enough of Peter, let's delete him"() {
        given: "Peter for the last time"
        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com").save(failOnError: true)
        def peter = new User(username: "peters", password: "geheim", signature: "signature", isReadOnly: false,  lastPasswordChange: new Date(), person: peterPerson)
        peter.save()

        when: "Peter is deleted"
        def  savedPeter = User.get(peter.id)
        savedPeter.delete(flush: true)

        then: "Peter is gone"
        !User.exists(savedPeter.id)
    }

    def "Let's check the constraints of the Class User"(){
        given: "Lazy Peter who fails on multiple items"
        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com").save(failOnError: true)
        def peter = new User(username: "peters", password: "geheim", signature: "signature", isReadOnly: false,  lastPasswordChange: new Date(), person: peterPerson)
        peter.username="pete"
        peter.password= "short"
        peter.signature="big"
        peter.save()

        when: "We validate Peter"
        peter.validate()

        then: "He has errors"
        peter.hasErrors()
        "size.toosmall" == peter.errors.getFieldError("password").code
        "short" == peter.errors.getFieldError("password").rejectedValue
        "size.toosmall" == peter.errors.getFieldError("signature").code
        "big" == peter.errors.getFieldError("signature").rejectedValue
        "size.toosmall" == peter.errors.getFieldError("username").code
        !peter.errors.getFieldError("lastPasswordChange")
    }

    def "Let's check if a user login might be given twice"(){
        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com").save(failOnError: true)
        def peteOne = new User(username: "peters", password: "password", signature: "signature", isReadOnly: false, isAdmin: false, lastPasswordChange: new Date(),
                person: peterPerson)
        def peteTwo = new User(username: "peters", password: "password", signature: "signature", isReadOnly: false, isAdmin: false, lastPasswordChange: new Date(),
                person: new Person(firstName: "Peter", lastName: "Panzer", email: "peter@panzer.de").save())

        when: "We validate the peters"
        peteOne.validate()
        peteOne.save()
        peteTwo.validate()
        peteTwo.save()

        then: "Peter 2 has errors"
        peteTwo.hasErrors()
        peteTwo.errors.getFieldError("username")
        "peters" == peteTwo.errors.getFieldError("username").rejectedValue
    }

    def "The password must not match the userId" (){
        given: "Peter who wants to use his username as password"
        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com").save()
        def peter = new User(username: "peters", password: "peters", signature: "big", isreadOnly: false, lastPasswordChange: new Date(), person: peterPerson)

        when: "We validate Peter"
        peter.validate()

        then: "Peter has errors"
        peter.hasErrors()
        peter.errors.getFieldError("password")
    }
}

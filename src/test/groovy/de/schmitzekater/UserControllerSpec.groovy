package de.schmitzekater

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(UserController)
@Mock([User, Person])
class UserControllerSpec extends Specification {

    /*def "Change Password is functional"(){
        *//*
        From Grails in Action, SE
         *//*
        given: "A correct user"

        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com")
        def peter = new User(userId: "peters", password: "geheim", signature: "signature", isReadOnly: false,  lastPasswordChange: new Date(), user: peterPerson)

        when: "Peter tries to change his password"
        peter.changePassword(peter, peter.getPassword(), "vielgeheimer")
        then: "Password is changed"
        peter.password == "vielgeheimer"

    }*/

    @Unroll
    def "Registration Command object for #userId validate correctly "() {
        given: "A mocked URC"
        def urc = mockCommandObject(UserRegistrationCommand)

        and: "a set of intial values from the spock test"
        urc.userId = userId
        urc.password = password
        urc.passwordRepeat = passwordRepeat
        urc.signature = signature
        urc.signatureRepeat = signatureRepeat
        urc.firstName = "Hans"
        urc.lastName = "Albers"
        urc.email = "hans@albers.de"


        when: "The validator is invoked"
        def isValidRegistration = urc.validate()

        then: "The appropriate fields are flagged as errors"
        isValidRegistration == anticipatedValid
        urc.errors.getFieldError(fieldInError)?.code == errorCode

        where:
        userId   | password   | passwordRepeat | signature | signatureRepeat | anticipatedValid | fieldInError      | errorCode
        "hansal" | "password" | "falsch"       | "Hanssig" | "Hanssig"       | false            | "passwordRepeat"  | "validator.invalid"
        "hansal" | "password" | "password"     | "Hanssig" | "passtnicht"    | false            | "signatureRepeat" | "validator.invalid"
        "hans"   | "password" | "password"     | "Hanssig" | "Hanssig"       | false            | "userId"          | "size.toosmall"
        "hansal" | "password" | "password"     | "Hanssig" | "Hanssig"       | true             | null              | null
    }
}

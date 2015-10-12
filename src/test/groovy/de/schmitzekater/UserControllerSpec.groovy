package de.schmitzekater

import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(UserController)
class UserControllerSpec extends Specification {


    def "Change Password is functional"(){
        given: "A correct user"

        def peterPerson = new Person(firstName: "Peter", lastName: "Parker", email: "peter@spiderman.com")
        def peter = new User(userId: "peters", password: "geheim", signature: "signature", isReadOnly: false,  lastPasswordChange: new Date(), person: peterPerson)

        when: "Peter tries to change his password"
        peter.changePassword(peter, peter.getPassword(), "vielgeheimer")
        then: "Password is changed"
        peter.password == "vielgeheimer"

    }
}

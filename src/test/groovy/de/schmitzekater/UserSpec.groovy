package de.schmitzekater

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
@Mock(User)
class UserSpec extends Specification {

    @Unroll
    def "Test password complexity"() {
        given: "A mocked User"
        def user = new User(username, password, signature, new Person(firstName: 'Peter', lastName: 'Mockingbird', email: 'peter@mockingbird.com'), new Date())
        /*user.username   = username
        user.signature  = signature
        user.password   = password
        user.person     = new Person(firstName: 'Peter', lastName: 'Mockingbird', email: 'peter@mockingbird.com')*/

        when: "The validator is invoked"
        def isValidUser = user.validate()

        then: "The appropriate fields are flagged as errors"
        isValidUser == anticipatedValid
        user.errors.getFieldError(fieldInError)?.code == errorCode

        where:
        username | password    | signature   | anticipatedValid | fieldInError | errorCode
        "peterm" | "password"  | "signature" | false            | "password"   | "validator.invalid"
        "peterm" | "pa55word"  | "signature" | false            | "password"   | "validator.invalid"
        "peterm" | "pas*wo%d"  | "signature" | false            | "password"   | "validator.invalid"
        "peterm" | "pass"      | "signature" | false            | "password"   | "minSize.notmet"
        "pete"   | "Passw0rd"  | "signature" | false            | "username"   | "size.toosmall"
        "peterm" | "Passw+rd"  | "signature" | false            | "password"   | "validator.invalid"
        "peterm" | "Passw+rd1" | "signature" | true             | null         | null
        "peterm" | "Passw0rd"  | "signature" | true             | null         | null
    }


}

package de.schmitzekater

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PersonService)
@Mock([Person])
class PersonServiceSpec extends Specification {

    def "A new person is created"() {
        given: "Nothing"
        when: "A new person is created"
        def batman = service.createPerson("Wayne", "Bruce", "batman@gotham.com")
        then: "Batman is saved"
        batman.firstName == "Bruce"
        notThrown(PersonException)
    }

    def "An invalid person is created"() {
        given: "Nothing"
        when: "An invalid person is created"
        def batman = service.createPerson("Wayne", "Bruce", "batmangotham.com")
        then: "An Exception is thrown"
        def ex = thrown(PersonException)
        ex.message == 'Ung�ltige Person'
    }

}

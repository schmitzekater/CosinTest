package de.schmitzekater

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test saving"() {
        def person = new Person(firstName: 'Anna', lastName: 'Meier', email: 'anana@email.de')
        assertNotNull(person.save(flush: true))
    }
}

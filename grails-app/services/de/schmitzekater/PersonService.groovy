package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.context.MessageSource

class PersonException extends RuntimeException {
    String message
    Person person
}

@Transactional
class PersonService {
    def createPerson(String lastName, String firstName, String email) {
        def person = new Person(firstName: firstName, lastName: lastName, email: email)
        if (person.validate() && person.save()) return person
        else throw new PersonException(message: 'Error creating person', person: person)
    }

}

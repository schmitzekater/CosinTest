package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.context.MessageSource

class PersonException extends RuntimeException {
    String message
    Person person
}

@Transactional
class PersonService {
    MessageSource messageSource

    def createPerson(String lastName, String firstName, String email) {
        println "Creating user"
        def person = new Person(firstName: firstName, lastName: lastName, email: email)
        if (person.validate()) return person
        else throw new PersonException(message: messageSource.getMessage('error.create.person', ['Person', [person.id]],null), person: person)
    }


    def serviceMethod() {

    }
}

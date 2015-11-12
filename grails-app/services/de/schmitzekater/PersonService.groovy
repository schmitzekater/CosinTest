package de.schmitzekater

import grails.transaction.Transactional

class PersonException extends RuntimeException {
    String message
    Person person
}

@Transactional
class PersonService {

    def createPerson(String lastName, String firstName, String email) {
        println "Creating person"
        def person = new Person(firstName: firstName, lastName: lastName, email: email)
        if (person.validate()) return person
        else throw new PersonException(message: "Ungueltige Person", person: person)
    }


    def serviceMethod() {

    }
}

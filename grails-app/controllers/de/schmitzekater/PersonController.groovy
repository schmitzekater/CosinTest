package de.schmitzekater

class PersonController {
    static scaffold = Person
    static defaultAction = "list"
    def personService
    def index() { }

    def list(){
        def persons = Person.getAll()
        return [persons: persons, numPersons: Person.count]
    }

    def createPerson(String lastName, String firstName, String email) {
        try {
            def person = personService.createPerson(lastName, firstName, email)
            flash.message = "Neue Person hinzugefügt: ${person.lastName}, ${person.firstName}"
        } catch (PersonException pe) {
            flash.message = pe.message
        }
        redirect(action: 'list')
    }

    def details() {
        [person: Person.findById(params.('id'))]
    }
}

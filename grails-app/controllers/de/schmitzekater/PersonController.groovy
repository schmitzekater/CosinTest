package de.schmitzekater

class PersonController {
    static scaffold = Person
    static defaultAction = "list"
    def index() { }

    def home(){
        render"<h1> Hier könnte ihre Person stehen</h1>"
    }
    def list(){
        def persons = Person.getAll()
        return [persons: persons, numPersons: Person.count]
    }

    def details() {
        [person: Person.findById(params.('id'))]
    }
}

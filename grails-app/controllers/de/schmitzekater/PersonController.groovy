package de.schmitzekater

class PersonController {
    static scaffold = Person
    static defaultAction = "list"
    def personService
    def index() { }

    def list(){
        def persons = Person.getAll()
        render view:"/layouts/list", model: [model:persons, count: Person.count]
    }

    def createPerson(String lastName, String firstName, String email) {
        def person
        try {
            person = personService.createPerson(lastName, firstName, email)
            flash.message = "Neue Person hinzugef�gt: ${person.lastName}, ${person.firstName}"
            redirect(action: 'details', params: person.id)
        } catch (PersonException pe) {
            flash.message = pe.message
        }
        if(!person){

        }
        else{

        }
    }

    def details() {
        def person = Person.findById(params.('id'))
        if(!person){
            response.sendError(404)
        }else{
        [person: person]
        }
    }
}

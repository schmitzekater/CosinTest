package de.schmitzekater

class PersonController {
    static scaffold = Person
    static defaultAction = "list"
    def personService
    def index() {
        redirect action: 'list', params: params
    }

    def show(){
        redirect action: 'detail', params: params
    }

    def list(){
        if(!params.max) params.max = 10
        def persons = Person.list(params)
        render view:"/layouts/list", model: [model:persons, count: Person.count]
    }

    def createPerson(String lastName, String firstName, String email) {
        def person
        try {
            person = personService.createPerson(lastName, firstName, email)
            flash.message = "Neue Person hinzugefügt: ${person.lastName}, ${person.firstName}"
            redirect(action: 'details', params: person.id)
        } catch (PersonException pe) {
            flash.message = pe.message
            redirect(action: 'create')
        }
        if(!person){

        }
        else{

        }
    }

    def detail() {
        def person = Person.findById(params.id)
        if(!person)  response.sendError(404)
        else  render view: "/layouts/detail", model: [person: person]
    }
}


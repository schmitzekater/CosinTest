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

    def create(){
        respond new Person(params)
    }

    def save() {
        println "Creating Person"
        def person
        try {
            person = personService.createPerson(params.lastName, params.firstName, params.email)
            flash.message = message(code: 'default.created.message', args: [message(code:'person.label'),person.getDisplayString()])
            redirect action: 'detail', id: person.id
        } catch (PersonException pe) {
            flash.error = pe.message
            respond pe.person.errors, view: 'create'
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


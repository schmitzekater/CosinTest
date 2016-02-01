package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Controller to handle the Domain class Person
 */
class PersonController {
    static scaffold = Person
    static defaultAction = "list"
    def personService               /** Dependency Injection for the PersonService */
    def index() {
        redirect action: 'list', params: params
    }

    def show(){
        redirect action: 'detail', params: params
    }

    /*
    Tabular view of all Persons
     */
    def list(){
        if(!params.max) params.max = 10
        def persons = Person.list(params)
        render view:"/layouts/list", model: [model:persons, count: Person.count]
    }

    /*
    Render view for a new Person.
     */
    def create(){
        respond new Person(params)
    }

    /*
    Save a new Person instance.
     */
    def save() {
        println "Creating Person"
        def person
        person = personService.createPerson(params.lastName, params.firstName, params.email)
        flash.message = message(code: 'default.created.message', args: [message(code:'person.label'),person.getDisplayString()])
        redirect action: 'detail', id: person.id
    }

    /*
    Detailed view of a single Person
     */
    def detail() {
        def person = Person.findById(params.id)
        if(!person)  response.sendError(404)
        else  render view: "/layouts/detail", model: [person: person]
    }

    /*
    Method to handle incoming PersonExceptions
     */
    def handlePersonException(PersonException pe){
        flash.error = pe.message
        respond pe.person.errors, view: 'create'
    }
}


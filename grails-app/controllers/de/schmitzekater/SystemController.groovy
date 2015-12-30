package de.schmitzekater

class SystemController {
    static scaffold = System
    static defaultAction = "list"

    def index() {
        redirect action: list(), params: params
    }

    def list() {
        if(!params.max) params.max = 10
        def systems = System.list(params)
        render view:"/layouts/list", model: [model:systems, count: System.count]
    }

    def create() {
        def system = new System(params)
        if (system.validate()){
            system.save(failOnError: true)
           flash.message = message(code: 'default.created.message', args: ['System', system.systemName])
            redirect(action: 'list')//, params: system.id)
        } else {
            flash.message = message(code: 'default.not.created.message', args:['System', system.systemName])
            logger.error('System could not be created')
        }

    }

    def update() {
        params.each { name, value ->
            println("Name: " + name + " Value: " + value)
        }
        def system = System.findById(params['id'])

        if (system) {
            def oldSystemName = system.systemName
            system.properties = params
            if (system.save()) {
                flash.message = message(code: 'default.updated.message', args: ['System', system.systemName])
                redirect(action: "list")
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['System', oldSystemName])
                redirect(action: "edit", id: params['id'])
            }

        } else {
            //  response.sendError(404)
        }

    }
    def detail() {
        def system = System.findById(params.id)
        render view: "/layouts/detail", model: [system: system]
    }


}

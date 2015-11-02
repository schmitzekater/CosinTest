package de.schmitzekater

class SystemController {
    static scaffold = System
    static defaultAction = "list"

    def index() {
        list()
    }

    def list() {
        def systems = System.getAll()
        return [systems: systems, numSystem: System.count]
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
                redirect(action: "list")//, id: params['id'])
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['System', oldSystemName])
                redirect(action: "edit", id: params['id'])
            }

        } else {
            //  response.sendError(404)
        }

    }


}

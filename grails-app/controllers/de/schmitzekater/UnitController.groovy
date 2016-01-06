package de.schmitzekater

class UnitController {
    static scaffold = Unit

    def index() {
        redirect action: list(), params: params
    }
    def list(){
        if(!params.max) params.max = 10
        def units = Unit.list(params)
        render view: "/layouts/list", model: [model: units, count: Unit.count()]
    }

    def addModule(){
        def module = Module.get(params.module)
        def unit = Unit.get(params.id)
        unit.addToModules(module)
        redirect action: 'show', id: module.id
    }
}

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
}

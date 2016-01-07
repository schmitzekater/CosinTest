package de.schmitzekater

class UnitController {
    static scaffold = Unit
    static defaultAction = "list"
    def unitService

    def index() {
        redirect action: list(), params: params
    }
    def list(){
        if(!params.max) params.max = 10
        def units = Unit.list(params)
        render view: "/layouts/list", model: [model: units, count: Unit.count]
    }

    def addModule(){
        def module = Module.get(params.module)
        def unit = Unit.get(params.id)
        unit.addToModules(module)
        redirect action: 'detail', id: unit.id
    }

    def removeModule(){
        params.each{ key, value ->
            println "Key: "+key+" Value: "+value
        }
        def module = Module.get(params.module)
        def unit = Unit.get(params.id)
        unit.removeFromModules(module)
        redirect action: 'detail', id: unit.id
    }

    def detail(){
        def unit = Unit.get(params.id)
        render view: "/layouts/detail", model: [unit: unit]
    }
    def show(){
        redirect action: 'detail', params: params
    }

}

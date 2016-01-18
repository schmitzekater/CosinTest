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
        def unit
        def module
        try{
            module = Module.get(params.module)
            unit = Unit.get(params.id)
            unit.addToModules(module)
            flash.message = message(code: "module.added.to.unit", args:[module.moduleName, unit.unitName])
        }
        catch(Exception e){
            flash.error = e.localizedMessage
        }
        redirect action: 'detail', id: params.id
    }

    def removeModule(){
        def unit
        try{
            def module = Module.get(params.module)
            unit = Unit.get(params.id)
            unit.removeFromModules(module)
            flash.message = message(code: "module.removed.from.unit", args:[module.moduleName, unit.unitName])
        }
        catch (Exception e){
            flash.error = e.localizedMessage
        }
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

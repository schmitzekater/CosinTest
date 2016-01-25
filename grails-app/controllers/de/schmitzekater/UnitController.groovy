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

    def addModuleToUnit(Unit unit) {
        model: [unit: unit]
    }

    def addModule(Unit unit){
        def module
        module = Module.get(params.module)
        unit.addToModules(module)
        flash.message = message(code: "module.added.to.unit", args:[module.moduleName, unit.unitName])
        redirect action: 'detail', id: params.id
    }

    def removeModule(Unit unit){
        def module = Module.get(params.module)
        unit.removeFromModules(module)
        flash.message = message(code: "module.removed.from.unit", args:[module.moduleName, unit.unitName])
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

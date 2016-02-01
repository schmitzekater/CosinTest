package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Controller to handle the Domain class Unit
 */
class UnitController {
    static scaffold = Unit
    static defaultAction = "list"
    def unitService                     /** Dependency Incetion for the UnitService     */

    def index() {
        redirect action: list(), params: params
    }

    /*
    Tabular view of all Units
     */
    def list(){
        if(!params.max) params.max = 10
        def units = Unit.list(params)
        render view: "/layouts/list", model: [model: units, count: Unit.count]
    }

    /*
    View to add a Module to the Unit
     */
    def addModuleToUnit(Unit unit) {
        model: [unit: unit]
    }

    /*
    Method to add a Module to the Unit
     */
    def addModule(Unit unit){
        def module
        module = Module.get(params.module)
        unit.addToModules(module)
        flash.message = message(code: "module.added.to.unit", args:[module.moduleName, unit.unitName])
        redirect action: 'detail', id: params.id
    }

    /*
    Method to remove a Module form the Unit
     */
    def removeModule(Unit unit){
        def module = Module.get(params.module)
        unit.removeFromModules(module)
        flash.message = message(code: "module.removed.from.unit", args:[module.moduleName, unit.unitName])
        redirect action: 'detail', id: unit.id
    }

    /*
    Detailed view of an Unit
     */
    def detail(){
        def unit = Unit.get(params.id)
        render view: "/layouts/detail", model: [unit: unit]
    }
    def show(){
        redirect action: 'detail', params: params
    }

}

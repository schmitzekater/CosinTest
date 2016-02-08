package de.schmitzekater

import java.util.Map

/**
 * @author Alexander Schmitz
 *
 * Controller to handle the Domain class Module
 */

class ModuleController {
    static scaffold = Module
    static defaultAction = "list"
    def qualificationService            /** Dependency Injection for the QualificationService       */
    def qualifiableObjectService        /** Dependency Injection for the QualififiableObjectService */

    def index() {
        redirect action: 'list', params: params
    }

    /*
    Tabular view of all Modules
     */
    def list() {
        if (!params.max) params.max = 10
        def modules = Module.list(params)
        render view: "/layouts/list", model: [model: modules, count: Module.count]
    }

    /*
    Method to add a new Qualification to a Module.
     */
    def addQualification(Module module) {
        if(!module){
            flash.error = message(code: 'module.isEmpty')
            log.error(flash.error)
        }
        else{
            def qualification
            // Create the new Qualification
            qualification = qualificationService.createQualification(params.qualificationDate, params.qualificationType, module, params.comment, request)
            // add Qualification to the Module
            if(qualifiableObjectService.addQualification(module, qualification)){
                flash.message = message(code: 'default.added.Qualification', args: ['Qualification', qualification.qualificationDate, module.moduleName])
                redirect action: "show", id: module.id
            }
            else{
                flash.error = message(code: 'qualification.not.added')
                log.error(flash.error)
            }
        }
    }

    /*
    Detailed view of a single Module
     */
    def detail() {
        render view: "/layouts/detail", model: [module: Module.findById(params.id)]
    }

    def show() {
        redirect action: 'detail', params: params
    }

    /*
    Method to retire a specific Module.
     */
    def retire(Module module) {
        if (qualifiableObjectService.retireModule(module)) {
            flash.message = message(code: 'module.successful.retired', args: ['Module', module.toString()])
            log.info(flash.message)
            redirect action: 'list'
        } else {
            flash.error = message(code: 'error.retiring.module', args: ['Module', module.toString()])
            log.error(flash.error)
        }
    }

    /*
    Renders a tabular view of all Qualifications for Modules
     */
    def listAllModuleQualifications() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getQualificationList(Module, checkedParams)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [checkedParams, params.dateTo = checkedParams.dateUntil]
    }

    /*
    Renders a tabular view of all Calibrations for Modules
     */
    def listAllModuleCalibrations() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getCalibrationList(Module, checkedParams)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [checkedParams, params.dateTo = checkedParams.dateUntil]
    }

    /*
    Render viewe to add a new Qualification.
    */
    def addQualificationToObject() {
        render view: "/layouts/addQualificationToObject", params: params
    }

    /*
    Method to handle incoming QualificationExceptions
    TODO: Implement Error Controller to handle all Exceptions. (add per Dependency Injection)
     */
    def handleQualificationException(QualificationException qe) {
        flash.error = qe.message
        log.error(qe.message)
        render view: '/error', model: [exception: qe]
    }

}

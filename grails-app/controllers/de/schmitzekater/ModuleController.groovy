package de.schmitzekater

import java.util.Map

class ModuleController {
    static scaffold = Module
    static defaultAction = "list"
    def qualificationService
    def qualifiableObjectService

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        if (!params.max) params.max = 10
        def modules = Module.list(params)
        render view: "/layouts/list", model: [model: modules, count: Module.count]
    }

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


    def detail() {
        render view: "/layouts/detail", model: [module: Module.findById(params.id)]
    }

    def show() {
        redirect action: 'detail', params: params
    }

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

    def listAllModuleQualifications() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getQualificationList(Module, checkedParams)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [checkedParams, params.dateTo = checkedParams.dateUntil]
    }

    def listAllModuleCalibrations() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getCalibrationList(Module, checkedParams)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [checkedParams, params.dateTo = checkedParams.dateUntil]
    }

/**
 * This function renders only the template to add a new Qualification.
 * Same as in "Software"
 * @return
 */
    def addQualificationToObject() {
        render view: "/layouts/addQualificationToObject", params: params
    }

    def handleQualificationException(QualificationException qe) {
        flash.error = qe.message
        log.error(qe.message)
        render view: '/error', model: [exception: qe]
    }

}

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

    def addQualification() {
        def qualification
        // Create the new Qualification
        qualification = qualificationService.createQualification(params.qualificationDate, params.qualificationType, params.module, params.comment, request)
        def module = Module.get(params.id)
        // Add the Qualification to the module
        module.addToQualifications(qualification)
        // Was the Qualification a Calibration??
        if (qualification.qualificationType.toString().equalsIgnoreCase("Calibration")) {
            // Get the last Calibration of the module
            def latestCalibration = module.lastCalibration
            Date qualDate = qualification.qualificationDate
            if (latestCalibration == null || qualDate > latestCalibration) {
                // Calculate the next calibration only if there wasn't any or the calibration is the newest.
                module.setLastCalibration(qualDate)
                module.setNextCalibration()
            }
            module.save()
        }
        flash.message = message(code: 'default.added.Qualification', args: ['Qualification', qualification.qualificationDate, module.moduleName])
        redirect action: "show", id: module.id
    }


    def detail() {
        render view: "/layouts/detail", model: [module: Module.findById(params.id)]
    }

    def show() {
        redirect action: 'detail', params: params
    }

    def retire(Module module) {
        module.setIsActive(false)
        module.setRetirementDate(params.retirementDate)
        if (module.save(failOnError: true)) {
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
                params: [params.dateFrom = checkedParams.dateFrom, params.dateTo = checkedParams.dateUntil, params.max = checkedParams.max,
                         params.offset = checkedParams.offset, params.sort = checkedParams.sortBy, params.order = checkedParams.orderBy]
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

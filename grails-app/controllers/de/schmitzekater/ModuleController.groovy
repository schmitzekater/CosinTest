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
        render view:"/layouts/list", model: [model: modules, count: Module.count]
    }
    def addQualification(){
        def qualification
        try{
            /*def f = request.getFile('attachment')
            String name = f.getOriginalFilename()
            //TODO Weitere Verzeichnisse anlege
            def uploadDir = servletContext.getRealPath("/uploads")
            File fileDest = new File(uploadDir,name)
            println "Dest: $fileDest"
            f.transferTo(fileDest)*/
            // Create the new Qualification
            qualification = qualificationService.createQualification(params.qualificationDate, params.qualificationType, params.module, params.comment)
            def module = Module.get(params.id)
            // Add the Qualification to the module
            module.addToQualifications(qualification)
            // Was the Qualification a Calibration??
            if(qualification.qualificationType.toString().equalsIgnoreCase("Calibration")){
                // Get the last Calibration of the module
                def latestCalibration = module.lastCalibration
                Date qualDate = qualification.qualificationDate
                if(latestCalibration ==null || qualDate>latestCalibration){
                    // Calculate the next calibration only if there wasn't any or the calibration is the newest.
                    module.setLastCalibration(qualDate)
                    module.setNextCalibration()
                }
                module.save()
            }
            flash.message = message(code: 'default.added.Qualification',args: ['Qualification',qualification.qualificationDate, module.moduleName])
            redirect action: "show", id: module.id
        }
        catch (QualificationException qe){
            flash.message = qe.message
            logger.error(qe.message)
        }
    }
    def detail(){
        render view: "/layouts/detail", model:  [module: Module.findById(params.id)]
    }

    def show(){
        redirect action: 'detail', params: params
    }

    def listAllModuleQualifications() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getQualificationList(Module, checkedParams.max, checkedParams.offset,
                checkedParams.dateFrom, checkedParams.dateUntil, checkedParams.sortBy, checkedParams.orderBy)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [params.dateFrom = checkedParams.dateFrom, params.dateTo = checkedParams.dateUntil, params.max = checkedParams.max,
                         params.offset = checkedParams.offset, params.sort = checkedParams.sortBy, params.order = checkedParams.orderBy]
    }

    def listAllModuleCalibrations() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getCalibrationList(Module, checkedParams.max, checkedParams.offset,
                checkedParams.dateFrom, checkedParams.dateUntil, checkedParams.sortBy, checkedParams.orderBy)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [params.dateFrom = checkedParams.dateFrom, params.dateTo = checkedParams.dateUntil, params.max = checkedParams.max,
                         params.offset = checkedParams.offset, params.sort = checkedParams.sortBy, params.order = checkedParams.orderBy]
    }

    /**
     * This function renders only the template to add a new Qualification.
     * Same as in "Software"
     * @return
     */
    def addQualificationToObject() {
        render view: "/layouts/addQualificationToObject", params: params
    }
}

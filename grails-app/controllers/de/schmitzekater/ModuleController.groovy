package de.schmitzekater

class ModuleController {
    static scaffold = Module
    static defaultAction = "list"
    def qualificationService

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
}

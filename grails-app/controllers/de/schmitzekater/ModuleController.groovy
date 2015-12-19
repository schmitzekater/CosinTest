package de.schmitzekater

class ModuleController {
    static scaffold = Module
    static defaultAction = "list"
    def qualificationService

    def index() {
        def modules = Module.getAll()
        render view:"/layouts/list", model: [model: modules, count: Module.count]
    }

    def list() {
        def modules = Module.getAll()
        render view:"/layouts/list", model: [model: modules, count: Module.count]
    }
    def addQualification(){
        def qualification
        try{
            qualification = qualificationService.createQualification(params.qualificationDate, params.qualificationType, params.module, params.comment)
            def module = Module.get(params.id)
            module.addToQualifications(qualification)
            flash.message = message(code: 'default.added.Qualification',args: ['Qualification',qualification.qualificationDate, module.moduleName])
            redirect action: "list"
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
        render view: "/layouts/detail", model:  [module: Module.findById(params.id)]
    }

    def update(){
        /**
         * Before the module is updated the next calibration should be calculated.
         */
        def qualification = Qualification.get(params.qualification.id)
        println "Qualification: "+qualification.getDisplayString()
        def module = Module.get(params.module.id)
        module.properties = params
        println "Module: "+module.getDisplayString()
        // Den Code nur ausführen, wenn man das Modul kalibrieren muss
        if(module.needsCalibration){
            // Diesen Code nur ausführen, wenn auch eine Qualifizierung gespeichert wurde
            if(qualification){
                // Diesen Code nur ausführen, wenn eine Kalibrierung gespeichert wurde
                if(qualification.qualificationType.compareToIgnoreCase('Calibration')){
                    Date qualDate = qualification.qualificationDate
                    /**
                     * TODO: Die jüngste Kalibrierung suchen
                     */
                    module.lastCalibration = qualDate
                    module.setNextCalibration()
                }
            }
        }

    }
}

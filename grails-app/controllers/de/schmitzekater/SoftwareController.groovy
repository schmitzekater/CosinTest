package de.schmitzekater

class SoftwareController {


    static scaffold = Software
    static defaultAction = "list"

    def qualificationService                /** Dependecy Injection for the QualificationService        */
    def qualifiableObjectService            /** Dependecy Injection for the QualifiableObjectService    */
    def index() {
        redirect action: list(), params: params
    }

    /*
    tabular view of all Software
     */
    def list() {
        if(!params.max) params.max = 10
        def sw = Software.list(params)
        render view:"/layouts/list", model: [model:sw, count: Software.count]
    }

    /*
    Method to add a new Qualification to a Software
     TODO: Refactor to another Controller with Module? Same actiosn.
     */
    def addQualification(Software software){
        if(!software){
            flash.error = message(code: 'software.isEmpty')
            log.error(flash.error)
        }
        else{
            def qualification
            qualification = qualificationService.createQualification(params.qualificationDate, params.qualificationType, software, params.comment, request)
            if(qualifiableObjectService.addQualification(software, qualification)) {
                flash.message = message(code: 'default.added.Qualification', args: ['Qualification', qualification.qualificationDate, software.softwareName])
                log.info(flash.message)
                redirect action: "list"
            }
            else{
                flash.error = message(code: 'qualification.not.added')
                log.error(flash.error)
            }
        }
    }

    /*
    List all Qualifications for the Domain class Software
     */
    def listAllSoftwareQualifications() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getQualificationList(Software, checkedParams)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [checkedParams, params.dateTo = checkedParams.dateUntil]
    }

    /*
    Render the view to add a new Qualification
    TODO: Refactor to another Controller with Module? Same actiosn.
     */
    def addQualificationToObject() {
        render view: "/layouts/addQualificationToObject", params: params
    }


    /*
    Detailed view of a single Software
     */
    def detail(){
        render view: "/layouts/detail", model:  [software: Software.findById(params.id)]
    }

    def show(){
        render view: "/layouts/detail", model:  [software: Software.findById(params.id)]
    }

    /*
    Exception Handling
     */
    def handleQualificationException(QualificationException qe) {
        flash.error = qe.message
        log.error(qe.message)
        render view: '/error', model: [exception: qe]
    }

    def handleFileExistsException(FileExistsException fe){
        if(fe.message=="File exists"){
            flash.error = message(code: "error.file.exists", args:[null,fe.existingFile.absolutePath])
            log.error(flash.error)
            render view: '/error', model: [exception: fe]
        }
    }

}

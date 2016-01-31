package de.schmitzekater

class SoftwareController {


    static scaffold = Software
    static defaultAction = "list"

    def qualificationService
    def qualifiableObjectService
    def index() {
        redirect action: list(), params: params
    }
    def list() {
        if(!params.max) params.max = 10
        def sw = Software.list(params)
        render view:"/layouts/list", model: [model:sw, count: Software.count]
    }

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

    def listAllSoftwareQualifications() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getQualificationList(Software, checkedParams)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [checkedParams, params.dateTo = checkedParams.dateUntil]
    }

/**
     * This function renders only the template to add a new Qualification.
     * Same as in "Module" TODO: One Controller? Always the same action??
     */
    def addQualificationToObject() {
        render view: "/layouts/addQualificationToObject", params: params
    }


    def saveAttachment(){
        def attachment = request.getFile('attachment').inputStream.text
        attachment.transferTo(new File('uploads/qualification/'))
    }

    def detail(){
        render view: "/layouts/detail", model:  [software: Software.findById(params.id)]
    }

    def show(){
        render view: "/layouts/detail", model:  [software: Software.findById(params.id)]
    }

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

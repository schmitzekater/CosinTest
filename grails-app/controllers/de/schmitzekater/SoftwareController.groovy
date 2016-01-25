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

    def addQualification(){
        def qualification
        try{
            qualification = qualificationService.createQualification(params.qualificationDate, params.qualificationType, params.software, params.comment)
            def software = Software.get(params.id)
            software.addToQualifications(qualification)
            flash.message = message(code: 'default.added.Qualification',args: ['Qualification',qualification.qualificationDate, software.softwareName ])
            redirect action: "list"
        }
        catch (QualificationException qe){
            flash.message = qe.message
            logger.error(qe.message)
        }
    }

    def listAllSoftwareQualifications() {
        def checkedParams = qualifiableObjectService.checkParams(params)
        def qualificationList = QualificationService.getQualificationList(Software, checkedParams.max, checkedParams.offset,
                checkedParams.dateFrom, checkedParams.dateUntil, checkedParams.sortBy, checkedParams.orderBy)
        render view: "/layouts/listAllQualifications", model: [model: qualificationList, count: qualificationList.getTotalCount()],
                params: [params.dateFrom = checkedParams.dateFrom, params.dateTo = checkedParams.dateUntil, params.max = checkedParams.max,
                         params.offset = checkedParams.offset, params.sort = checkedParams.sortBy, params.order = checkedParams.orderBy]
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
}

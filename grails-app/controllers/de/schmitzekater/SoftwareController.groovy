package de.schmitzekater

class SoftwareController {
    static scaffold = Software
    static defaultAction = "list"

    def qualificationService
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

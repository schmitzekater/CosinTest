package de.schmitzekater

class SoftwareController {
    static scaffold = Software
    static defaultAction = "list"

    def qualificationService
    def index() {}
    def list() {
        def sw = Software.getAll()
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

    def listQualifications(){
        def software = Software.get(params.id)
        def qualifications = software.getQualifications()
        render template: "/layouts/listQualifications", model: [model: qualifications]
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

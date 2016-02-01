package de.schmitzekater

class CommonController {

    def fileHandleService

    def index() {
        redirect action: 'imprint'
    }

    def imprint(){
        def lang = getLanguage()
        render view: lang+'/imprint'
    }

    def disclaimer(){
        def lang = getLanguage()
        render view: lang+'/disclaimer'
    }

    String getLanguage(){
        def language
        if(!params.lang) {
            if(!session.language){
                language = 'de'
            }
            else{
                language = session.language
            }
        }
        else{
            language = params.lang
        }
        log.info("Language: $language")
        language
    }

    def downloadAttachment(Qualification qualification) {
        String name = qualification.attachment.name
        String path = qualification.attachment.absolutePath
        fileHandleService.downloadFile(response, name, path)
    }

    def downloadDataflow(System system) {
        String name = system.dataFlow.name
        String path = system.dataFlow.absolutePath
        fileHandleService.downloadFile(response, name, path)
    }
}

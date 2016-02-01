package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Controller to handle "common" actions and to display Domain-independent sites.
 * Displays imprint, disclaimer and sets the language.
 * Also used to download Documents (via @fileHandleService)
 */
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

    /**
     * Sets the language for the current user / session
     * If no language is set, the default language 'de' is set.
     * @return param language
     */
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

    /**
     * Method to initiate the download of a qualification attachement.
     * @param qualification the qualification that contains the attachment.
     * @return redirects to @fileHandleService
     */
    def downloadAttachment(Qualification qualification) {
        String name = qualification.attachment.name
        String path = qualification.attachment.absolutePath
        fileHandleService.downloadFile(response, name, path)
    }
    /**
     * Method to initiate the download of a qualification attachement.
     * @param system The System where the dataflow file is attached to.
     * @return redirects to @fileHandleService
     */
    def downloadDataflow(System system) {
        String name = system.dataFlow.name
        String path = system.dataFlow.absolutePath
        fileHandleService.downloadFile(response, name, path)
    }
}

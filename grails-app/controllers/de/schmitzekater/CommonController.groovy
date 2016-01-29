package de.schmitzekater

class CommonController {

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
}

import org.grails.web.gsp.io.GrailsConventionGroovyPageLocator


class CosinTagLib____ {
    static namespace = "cos"
    static returnObjectForTags = ['templateExists']

    def navExists = { attrs, body ->
        def pageLocator = GrailsConventionGroovyPageLocator.newInstance()
        String template = "$controllerName" + attrs.loc
        println "Template: " + template
        def source = pageLocator.findTemplate(controllerName, template)
        if (source == null) {
            println "Not found"
            return false
        } else {
            println "Found template"
            return true
        }
    }
}
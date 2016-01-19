package de

import grails.plugins.GrailsPluginManager
import groovy.text.Template
import org.grails.gsp.io.GroovyPageCompiledScriptSource
import org.grails.gsp.io.GroovyPageLocator
import org.grails.gsp.io.GroovyPageScriptSource
import org.grails.taglib.TemplateVariableBinding
import org.grails.web.gsp.io.GrailsConventionGroovyPageLocator
import org.springframework.core.io.ResourceLoader

class SchmitzekaterTagLib {
    // static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    GrailsConventionGroovyPageLocator groovyPageLocator
    static namespace = "cos"
    static returnObjectForTags = ['templateExists']

    /**
     * Diese Funktion sieht nach, ob ein Navigations-Template vorhanden ist.
     * Generiert für die Sidebars links und rechts. Falls ein Template 'controllerName'+'Location' gefunden wird,
     * wird dies angezeigt. Ansonsten nur die Standard-Navigation.
     * So lassen sich spezielle Controller-Links / Funktionen in die Sidebar einbauen, falls man sie braucht
     * (unabhängig von der Normalen Navigation, die überall gleich ist)
     */
    def templateExists = { attrs ->
        def template = "$controllerName" + attrs.loc   //Meine Definition von Templatenamen
        out << "<!-- Testing Template -->"
        def path = "/" + controllerName + "/"
        def source = groovyPageLocator.findTemplate(controllerName, template)

        if (source) {
            log.info("Found template $template in path $path")
            return true
        } else {
            log.debug("No template found for $template in path $path")
            return false
        }
    }

    def cancelButton = { attrs, body ->
        out << """
            <input class="btn btn-error" type="button" onclick="window.history.back()" value="${
            message(code: 'default.cancel.button', default: 'Cancel')
        }" title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
                """

    }

    def addEditCancelButtons = { attrs, body ->
        out << """
         <fieldset class="buttons">
            <input class="btn btn-success" action="update" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}" title="${
            message(code: 'default.button.update.label', default: 'Update')
        }"/>
            <input class="btn btn-danger" type="button" onclick="window.history.back()" value="${
            message(code: 'default.cancel.button', default: 'Cancel')
        }" title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
          </fieldset>
            """
    }
    def addCreateCancelButtons = { attrs, body ->
        out << """
         <fieldset class="buttons">
             <input class="btn btn-primary" action="create" type="submit"
                   value="${message(code: 'default.button.create.label', default: 'Create')}" title="${
            message(code: 'default.button.create.label', default: 'Create')
        }"/>
            <input class="btn btn-danger" type="button" onclick="window.history.back()" value="${
            message(code: 'default.cancel.button', default: 'Cancel')
        }" title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
          </fieldset>
            """
    }
}
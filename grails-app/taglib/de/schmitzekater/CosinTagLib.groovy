package de.schmitzekater

import grails.util.TypeConvertingMap
import grails.web.mapping.UrlMapping

import org.grails.encoder.CodecLookup
import org.grails.taglib.TagOutput
import org.grails.taglib.encoder.OutputContextLookupHelper
import org.grails.web.gsp.io.GrailsConventionGroovyPageLocator
import org.springframework.web.servlet.support.RequestContextUtils

class CosinTagLib {
    // static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    GrailsConventionGroovyPageLocator groovyPageLocator
    static namespace = "cos"
    static returnObjectForTags = ['templateExists']
    CodecLookup codecLookup

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

    /*
    Adds a Cancel Button (=history back)
     */
    def cancelButton = { attrs, body ->
        out << """
            <input class="btn btn-error" type="button" onclick="window.history.back()" value="${
            message(code: 'default.cancel.button', default: 'Cancel')
        }" title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
                """

    }

    /*
    Adds an update and a cancel Button.
    Yeah, the Methodname is irritating!
     */
    def addEditCancelButtons = { attrs, body ->
        out << """
         <fieldset class="buttons">
            <input class="btn btn-success" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}" title="${
            message(code: 'default.button.update.label', default: 'Update')
        }"/>
            <input class="btn btn-danger" type="button" onclick="window.history.back()" value="${
            message(code: 'default.cancel.button', default: 'Cancel')
        }" title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
          </fieldset>
            """
    }

    /*
    Adds the combination of create and cancel buton
     */
    def addCreateCancelButtons = { attrs, body ->
        out << """
         <fieldset class="buttons">
             <input class="btn btn-primary" type="submit"
                   value="${message(code: 'default.button.create.label', default: 'Create')}" title="${
            message(code: 'default.button.create.label', default: 'Create')
        }"/>
            <input class="btn btn-danger" type="button" onclick="window.history.back()" value="${
            message(code: 'default.cancel.button', default: 'Cancel')
        }" title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
          </fieldset>
            """
    }

    def linkTo = {attrs, body ->
        out << """
                 <p><a href="${attrs.anchor}">${attrs.value}</a></p>
            """
    }

    def successText = { attrs, body ->
        out << """
            <div class="alert alert-success"><span class="glyphicon glyphicon-ok-sign"></span>$body</div>
            """
    }

    def infoText = {attrs, body ->
        out << """
            <div class="alert alert-info"><span class="glyphicon glyphicon-info-sign"></span>$body</div>
                """
    }

    def errorText = { attrs, body ->
        out << """
            <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span>$body</div>
            """
    }

    def alertText = {attrs, body ->
        out << """
            <div class="alert alert-warning"><span class="glyphicon glyphicon-exclamation-sign"></span>$body</div>
            """
    }

    /**
     * Override the default Paginate!!
     */
    /** From the original Source: https://github.com/grails/grails-core/blob/0b1d6a6d02f2217643a69e8314f76078dacbce32/grails-plugin-gsp/src/main/groovy/org/grails/plugins/web/taglib/UrlMappingTagLib.groovy
     * Creates next/previous links to support pagination for the current controller.<br/>
     *
     * &lt;g:paginate total="${Account.count()}" /&gt;<br/>
     *
     * @emptyTag
     *
     * @attr total REQUIRED The total number of results to paginate
     * @attr action the name of the action to use in the link, if not specified the default action will be linked
     * @attr controller the name of the controller to use in the link, if not specified the current controller will be linked
     * @attr id The id to use in the link
     * @attr params A map containing request parameters
     * @attr prev The text to display for the previous link (defaults to "Previous" as defined by default.paginate.prev property in I18n messages.properties)
     * @attr next The text to display for the next link (defaults to "Next" as defined by default.paginate.next property in I18n messages.properties)
     * @attr omitPrev Whether to not show the previous link (if set to true, the previous link will not be shown)
     * @attr omitNext Whether to not show the next link (if set to true, the next link will not be shown)
     * @attr omitFirst Whether to not show the first link (if set to true, the first link will not be shown)
     * @attr omitLast Whether to not show the last link (if set to true, the last link will not be shown)
     * @attr max The number of records displayed per page (defaults to 10). Used ONLY if params.max is empty
     * @attr maxsteps The number of steps displayed for pagination (defaults to 10). Used ONLY if params.maxsteps is empty
     * @attr offset Used only if params.offset is empty
     * @attr mapping The named URL mapping to use to rewrite the link
     * @attr fragment The link fragment (often called anchor tag) to use
     */
    Closure paginate = { Map attrsMap ->
        TypeConvertingMap attrs = (TypeConvertingMap)attrsMap
        def writer = out
        if (attrs.total == null) {
            throwTagError("Tag [paginate] is missing required attribute [total]")
        }

        def messageSource = grailsAttributes.messageSource
        def locale = RequestContextUtils.getLocale(request)

        def total = attrs.int('total') ?: 0
        def offset = params.int('offset') ?: 0
        def max = params.int('max')
        def maxsteps = (attrs.int('maxsteps') ?: 10)

        if (!offset) offset = (attrs.int('offset') ?: 0)
        if (!max) max = (attrs.int('max') ?: 10)

        Map linkParams = [:]
        if (attrs.params instanceof Map) linkParams.putAll((Map)attrs.params)
        linkParams.offset = offset - max
        linkParams.max = max
        if (params.sort) linkParams.sort = params.sort
        if (params.order) linkParams.order = params.order

        Map linkTagAttrs = [:]
        def action
        if (attrs.containsKey('mapping')) {
            linkTagAttrs.mapping = attrs.mapping
            action = attrs.action
        } else {
            action = attrs.action ?: params.action
        }
        if (action) {
            linkTagAttrs.action = action
        }
        if (attrs.controller) {
            linkTagAttrs.controller = attrs.controller
        }
        if (attrs.containsKey(UrlMapping.PLUGIN)) {
            linkTagAttrs.put(UrlMapping.PLUGIN, attrs.get(UrlMapping.PLUGIN))
        }
        if (attrs.containsKey(UrlMapping.NAMESPACE)) {
            linkTagAttrs.put(UrlMapping.NAMESPACE, attrs.get(UrlMapping.NAMESPACE))
        }
        if (attrs.id != null) {
            linkTagAttrs.id = attrs.id
        }
        if (attrs.fragment != null) {
            linkTagAttrs.fragment = attrs.fragment
        }
        linkTagAttrs.params = linkParams

        // determine paging variables
        def steps = maxsteps > 0
        int currentstep = ((offset / max) as int) + 1
        int firststep = 1
        int laststep = Math.round(Math.ceil(total / max)) as int

        // display previous link when not on firststep unless omitPrev is true
        if (currentstep > firststep && !attrs.boolean('omitPrev')) {
            linkTagAttrs.put('class', 'prevLink')
            linkParams.offset = offset - max
            writer << "<li>"
            writer << callLink((Map)linkTagAttrs.clone()) {
                (attrs.prev ?: messageSource.getMessage('paginate.prev', null, messageSource.getMessage('default.paginate.prev', null, 'Previous', locale), locale))
            }
            writer << "</li>"
        }

        // display steps when steps are enabled and laststep is not firststep
        if (steps && laststep > firststep) {
            linkTagAttrs.put('class', 'step')

            // determine begin and endstep paging variables
            int beginstep = currentstep - (Math.round(maxsteps / 2.0d) as int) + (maxsteps % 2)
            int endstep = currentstep + (Math.round(maxsteps / 2.0d) as int) - 1

            if (beginstep < firststep) {
                beginstep = firststep
                endstep = maxsteps
            }
            if (endstep > laststep) {
                beginstep = laststep - maxsteps + 1
                if (beginstep < firststep) {
                    beginstep = firststep
                }
                endstep = laststep
            }

            // display firststep link when beginstep is not firststep
            if (beginstep > firststep && !attrs.boolean('omitFirst')) {
                linkParams.offset = 0
                writer << "<li>"
                writer << callLink((Map)linkTagAttrs.clone()) {firststep.toString()}
                writer << "</li>"
            }
            //show a gap if beginstep isn't immediately after firststep, and if were not omitting first or rev
            if (beginstep > firststep+1 && (!attrs.boolean('omitFirst') || !attrs.boolean('omitPrev')) ) {
                writer << '<li class="disabled"><a href="#">..</a></li>'
            }

            // display paginate steps
            (beginstep..endstep).each { int i ->
                if (currentstep == i) {
                    writer << "<li class='active'><a href='#'>$i</a></li>"
                }
                else {
                    linkParams.offset = (i - 1) * max
                    writer << "<li>"
                    writer << callLink((Map)linkTagAttrs.clone()) {i.toString()}
                    writer << "</li>"
                }
            }

            //show a gap if beginstep isn't immediately before firststep, and if were not omitting first or rev
            if (endstep+1 < laststep && (!attrs.boolean('omitLast') || !attrs.boolean('omitNext'))) {
                writer << '<li class="disabled"><a href="#">..</a></li>'

            }
            // display laststep link when endstep is not laststep
            if (endstep < laststep && !attrs.boolean('omitLast')) {
                linkParams.offset = (laststep - 1) * max
                writer << "<li>"
                writer << callLink((Map)linkTagAttrs.clone()) { laststep.toString() }
                writer << "</li>"
            }
        }

        // display next link when not on laststep unless omitNext is true
        if (currentstep < laststep && !attrs.boolean('omitNext')) {
            linkTagAttrs.put('class', 'nextLink')
            linkParams.offset = offset + max
            writer << "<li>"
            writer << callLink((Map)linkTagAttrs.clone()) {
                (attrs.next ? attrs.next : messageSource.getMessage('paginate.next', null, messageSource.getMessage('default.paginate.next', null, 'Next', locale), locale))
            }
            writer << "</li>"
        }
    }
    private callLink(Map attrs, Object body) {
        TagOutput.captureTagOutput(tagLibraryLookup, 'g', 'link', attrs, body, OutputContextLookupHelper.lookupOutputContext())
    }


}
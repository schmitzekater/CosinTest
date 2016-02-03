<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="softwareName" title="${message(code: 'software.softwareName.label', default: 'Software Name')}" />
        <g:sortableColumn property="softwareVersion" title="${message(code: 'software.softwareVersion.label', default: 'Version')}"/>
        <g:sortableColumn property="softwareVendor" title="${message(code: 'vendor.vendorName.label', default: 'Vendor')}"/>
        <g:sortableColumn property="system" title="${message(code: 'system.systemName.label', default: 'System')}" />
        <g:if test="${controllerName.compareToIgnoreCase('Software')==0}">
            <th><a href="#"><g:message code='action.label'/></a></th>
        </g:if>
        <g:else>
            <th/>
        </g:else>
    </tr>
    </thead>
    <tbody>
    <g:each var="software" in="${model}">
        <tr>
            <f:with bean="${software}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="softwareName" wrapper="list"/>
                <f:display property="softwareVersion" wrapper="list"/>
                <f:display property="softwareVendor" wrapper="list/link/vendor"/>
                <f:display property="system" wrapper="list/link/system"/>

            </f:with>
            %{--Only render the Buttons if on Software-Controller--}%
            <g:if test="${controllerName.compareToIgnoreCase('Software')==0}">
                <g:render template="/layouts/editInfoButtons" model="[model: software]"/>
            </g:if>
            %{-- Render the remove button if on System controller --}%
            <g:if test="${controllerName.compareToIgnoreCase('System')==0}">
                <td>
                <g:link action="detail" id="${software.id}" controller="software">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
                            code="info.software"/>'></span>
                </g:link>
                <sec:link controller="system" action="removeSoftware" id="${params.id}" params="[software: software.id]"
                          expression="hasAnyRole('ROLE_EDIT,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-minus-sign" aria-hidden="true" style="color:red" title='<g:message
                        code="system.remove.software"/>'>&nbsp;</span>
                </sec:link>
                </td>
            </g:if>
            <g:if test="${controllerName.compareToIgnoreCase('Computer') == 0}">
                <td>
                <g:link action="detail" id="${software.id}" controller="software">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
                            code="info.software"/>'></span>
                </g:link>
                <sec:link controller="computer" action="removeSoftware" id="${params.id}"
                          params="[software: software.id]"
                          expression="hasAnyRole('ROLE_EDIT,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-minus-sign" aria-hidden="true" style="color:red" title='<g:message
                        code="computer.remove.software"/>'>&nbsp;</span>
                </sec:link>
                </td>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
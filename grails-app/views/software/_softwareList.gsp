<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="softwareName" title="${message(code: 'software.softwareName.label', default: 'Software Name')}" />
        <g:sortableColumn property="softwareVersion" title="${message(code: 'software.softwareVersion.label', default: 'Version')}"/>
        <g:sortableColumn property="softwareVendor" title="${message(code: 'vendor.vendorName.label', default: 'Vendor')}"/>
        <g:sortableColumn property="system" title="${message(code: 'system.systemName.label', default: 'System')}" />
        <td><g:message code= 'action.label'/></td>
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
        </tr>
    </g:each>
    </tbody>
</table>
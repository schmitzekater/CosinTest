<%@ page import="de.schmitzekater.*" %>

<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="computerName" title="${message(code: 'computer.computerName.label', default: 'Name')}"/>
        <g:sortableColumn property="computerVendor" title="${message(code: 'computer.computerVendor.label', default: 'Vendor')}"/>
        <g:sortableColumn property="computerRole" title="${message(code: 'computer.computerRole.label', default: 'Role')}"/>
        <g:sortableColumn property="system" title="${message(code: 'system.name.label', default: 'System')}"/>
    </tr>
    </thead>
    <tbody>
    <g:each var="computer" in="${model}">
        <tr>
            <f:with bean="${computer}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="computerName"  wrapper="list"/>
                <f:display property="computerVendor" wrapper="list/link/vendor"/>
                <f:display property="computerRole" wrapper="list"/>
                <f:display property="system" wrapper="list/link/system"/>
            </f:with>

            <g:if test="${controllerName.compareToIgnoreCase('Computer')==0}">
                <g:render template="/layouts/editInfoButtons" model="[model: computer]"/>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
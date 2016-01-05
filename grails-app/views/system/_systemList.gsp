<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="systemName" title="${message(code: 'system.name.label', default:'Name')}" />
        <g:sortableColumn property="systemDepartment" title="${message(code: 'department.departmentName.label', default:'Department')}" />
        <g:sortableColumn property="systemOwner" title="${message(code: 'system.systemOwner.label', default:'System Owner')}" />
        <g:sortableColumn property="processOwner" title="${message(code: 'system.processOwner.label', default:'System Owner')}" />
        <td><g:message code= 'action.label'/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="system" in="${model}">
       <tr>
            <f:with bean="${system}">
                <f:display property="id" wrapper="list"/>
                <f:display property="systemName" wrapper="list"/>
                <f:display property="systemDepartment" wrapper="list/link"/>
                <f:display property="systemOwner" wrapper="list/link"/>
                <f:display property="processOwner" wrapper="list/link"/>
            </f:with>
           <g:render template="/layouts/editInfoButtons" model="[model: system]"/>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="systemName" title="${message(code: 'system.name.label', default:'Name')}" />
        <g:sortableColumn property="systemDepartment" title="${message(code: 'department.departmentName.label', default:'Department')}" />
        <g:sortableColumn property="systemOwner" title="${message(code: 'system.systemOwner.label', default:'System Owner')}" />
        <g:sortableColumn property="processOwner" title="${message(code: 'system.processOwner.label', default:'System Owner')}" />
        <g:sortableColumn property="systemDataCategory" title="${message(code: 'system.dataCategory.label', default:'Data Category')}" />
        <th><a><g:message code="computer.label"/></a></th>
        <th><a><g:message code="unit.label"/></a></th>
        <th><a><g:message code="software.label"/></a></th>
        <g:if test="${controllerName.compareToIgnoreCase('System')==0}">
            <th><a href="#"><g:message code='action.label'/></a></th>
        </g:if>
    </tr>
    </thead>
    <tbody>
    <g:each var="system" in="${model}">
       <tr>
            <f:with bean="${system}">
                <f:display property="id" wrapper="list"/>
                <f:display property="systemName" wrapper="list"/>
                <f:display property="systemDepartment" wrapper="list/link/department"/>
                <f:display property="systemOwner" wrapper="list/link/person"/>
                <f:display property="processOwner" wrapper="list/link/person"/>
                <f:display property="systemDataCategory" wrapper="list"/>
                <td>${system.computer.size()}</td>
                <td>${system.units.size()}</td>
                <td>${system.usesSoftware.size()}</td>
            </f:with>
           <g:if test="${controllerName.compareToIgnoreCase('System')==0}">
               <g:render template="/layouts/editInfoButtons" model="[model: system]"/>
           </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
<%@ page import="de.schmitzekater.User" %>

<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td>
        <td><g:message code="system.name.label"/></td>
        <td><g:message code="department.departmentName.label"/> </td>
        <td><g:message code="system.systemOwner.label"/></td>
        <td><g:message code="system.processOwner.label"/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="system" in="${model}">
        <tr>
            <td><g:link action="show" id="${system.id}">${system.id}</g:link></td>
            %{-- TODO: Umstellen auf Felder!! Dabei auf missing values achten!--}%
            <td>${system.systemName}</td>
            <td>${system.systemDepartment.departmentName}</td>
            <td><g:link controller="person" id="${system.systemOwner.id}" action="detail">${system.systemOwner.lastName}, ${system.systemOwner.firstName}</g:link></td>
            <td><g:link controller="person" id="${system.processOwner.id}" action="detail"> ${system.processOwner.lastName}, ${system.processOwner.firstName}</g:link></td>
           <g:render template="/layouts/editInfoButtons" model="[model: system]"/>
        </tr>
    </g:each>
    </tbody>
</table>
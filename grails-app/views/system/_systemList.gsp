<%@ page import="de.schmitzekater.User" %>

<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td><td>System Name</td><td>System Owner</td><td>Process Owner</td>
    </tr>
    </thead>
    <tbody>
    <g:each var="system" in="${systems}">
        <tr>
            <td><g:link action="show" id="${system.id}">${system.id}</g:link></td>
            <td>${system.systemName}</td>
            <td>${system.systemOwner}</td>
            <td>${system.processOwner}</td>
            <td>
                <g:link controller="System" action="edit" id="${system.id}"><g:message code="default.edit.label"
                                                                                       args="[entityName]"/></g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
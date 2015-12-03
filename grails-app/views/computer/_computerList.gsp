<%@ page import="de.schmitzekater.*" %>

<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td>
        <td><g:message code="computer.computerName.label"/></td>
        <td><g:message code="computer.computerVendor.label"/> </td>
        <td><g:message code="computer.computerRole.label"/></td>
        <td><g:message code="system.name.label"/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="computer" in="${model}">
        <tr>
            <td><g:link action="show" id="${computer.id}">${computer.id}</g:link></td>
            %{-- TODO: Umstellen auf Felder!! Dabei auf missing values achten!--}%
            <td>${computer.computerName}</td>
            <td><g:link controller="vendor" id="${computer.computerVendor.id}" action="detail">${computer.computerVendor.getDisplayString()}</g:link></td>
            <td>${computer.computerRole.getDisplayString()}</td>
            <td>
                <g:if test="${computer.system != null}">
                    <g:link controller="system" id="${computer.system.id}" action="detail"> ${computer.system.systemName}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
            <g:render template="/layouts/editInfoButtons" model="[model: computer]"/>
        </tr>
    </g:each>
    </tbody>
</table>
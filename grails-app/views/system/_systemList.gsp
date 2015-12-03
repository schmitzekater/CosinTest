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
            <td>
                <g:if test="${system.systemDepartment != null}">
                    <g:link controller="Department" action="detail" id="${system.systemDepartment.id}">${system.systemDepartment.departmentName}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
            <td>
                <g:if test="${system.systemOwner != null}">
                  <g:link controller="person" id="${system.systemOwner.id}" action="detail">${system.systemOwner.getDisplayString()}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
            <td>
                <g:if test="${system.processOwner != null}">
                    <g:link controller="person" id="${system.processOwner.id}" action="detail"> ${system.processOwner.getDisplayString()}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
           <g:render template="/layouts/editInfoButtons" model="[model: system]"/>
        </tr>
    </g:each>
    </tbody>
</table>
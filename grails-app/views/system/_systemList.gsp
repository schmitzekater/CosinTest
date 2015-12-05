<%@ page import="de.schmitzekater.User" %>

<table class="table table-striped">
    <thead>
    <tr>
        <td><g:message code="system.name.label"/></td>
        <td><g:message code="department.departmentName.label"/> </td>
        <td><g:message code="system.systemOwner.label"/></td>
        <td><g:message code="system.processOwner.label"/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="system" in="${model}">
       <tr>
            <f:with bean="${system}">
                <f:display property="systemName"/>
                <f:display property="systemDepartment"/>
                <f:display property="systemOwner"/>
                <f:display property="processOwner"/>
            </f:with>
           <g:render template="/layouts/editInfoButtons" model="[model: system]"/>
        </tr>
    </g:each>
    </tbody>
</table>
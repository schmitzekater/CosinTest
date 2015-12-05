<%@ page import="de.schmitzekater.User" %>
<table class="table table-striped">
    <thead>
    <tr>
        <td><g:message code="user.userId.label"/> </td>
        <td><g:message code="user.password.label"/> </td>
        <td><g:message code="user.signature.label"/> </td>
        <td><g:message code="person.label"/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="user" in="${model}">
        <tr>
            <f:with bean="${user}">
                <f:display property="userId"/>
                <f:display property="password"/>
                <f:display property="signature"/>
                <f:display property="person"/>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: user]" />
        </tr>
    </g:each>
    </tbody>
</table>
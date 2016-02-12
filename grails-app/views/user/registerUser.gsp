<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 07.11.2015
  Time: 11:42
--%>

<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
</head>

<body role="document">
    <!-- Main Block start -->
        <div id="create-User"  role="main">
            <h1><g:message code="default.create.label" args="[entityName]"/></h1>

        <g:form action="register" controller="user">
            <table class="table-striped table-condensed">
                <f:with bean="userRegistrationCommand">
                    <f:field property="username"  wrapper="edit/table"/>
                    <f:field property="password"  wrapper="edit/table/secret"/>
                    <f:field property="passwordRepeat"  wrapper="edit/table/secret"/>
                    <f:field property="signature" wrapper="edit/table/secret"/>
                    <f:field property="signatureRepeat" wrapper="edit/table/secret"/>
                    <f:field property="firstName" wrapper="edit/table"/>
                    <f:field property="lastName" wrapper="edit/table"/>
                    <f:field property="email" wrapper="edit/table"/>
                </f:with>
                    <tr>
                        <td><label for="userRoleGroup"><g:message code="user.roleGroup.label"/></label></td>
                        <td><g:select from="${RoleGroup.findAll()}" optionKey="id" optionValue="displayString"
                                      noSelection="${['null': '<N/A>']}"
                                      name="userRoleGroup"/></td>
                    </tr>
                    <tr class="form-actions">
                        <td colspan="2">
                            <g:submitButton name="register" class="btn btn-primary"
                                        value="${message(code: 'default.button.create.label', default: 'Register')}"/>
                            <input class="btn btn-danger" type="button" onclick="window.history.back()"
                                   value="${message(code: 'default.cancel.button', default: 'Cancel')}"
                                   title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
                        </td>
                    </tr>

                </table>
            </g:form>

        </div>
</body>
</html>

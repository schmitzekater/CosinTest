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
                <fieldset class="form">
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="username"><g:message code="user.username.label"/> *</label>
                        </td>
                        <td>
                            <g:textField name="username" value="${user.username}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="password"><g:message code="user.password.label"/> *</label>
                        </td>
                        <td>
                            <g:passwordField name="password" value="${user?.password}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="passwordRepeat"><g:message code="user.password.label"/> <g:message code="default.entry.repeat"/> *</label>
                        </td>
                        <td>
                            <g:passwordField name="passwordRepeat" value="${user?.passwordRepeat}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="signature"><g:message code="user.signature.label"/> *</label>
                        </td>
                        <td>
                            <g:passwordField name="signature" value="${user?.signature}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                          <label for="signatureRepeat"><g:message code="user.signature.label"/> <g:message code="default.entry.repeat"/> *</label>
                        </td>
                        <td>
                            <g:passwordField name="signatureRepeat" value="${user?.signatureRepeat}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="firstName"><g:message code="person.firstName.label"/> *</label>
                        </td>
                        <td>
                            <g:textField name="firstName" value="${user?.firstName}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="lastName"><g:message code="person.lastName.label"/> *</label>
                        </td>
                        <td>
                            <g:textField name="lastName" value="${user?.lastName}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="email"><g:message code="person.email.label"/> *</label>
                        </td>
                        <td>
                            <g:textField name="email" value="${user?.email}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="userRoleGroup"><g:message code="user.roleGroup.label"/></label></td>
                        <td><g:select from="${RoleGroup.findAll()}" optionKey="id" optionValue="displayString"
                                      noSelection="${['null': '<N/A>']}"
                                      name="userRoleGroup" multiple="false"/></td>
                    </tr>
                    <tr class="form-actions">
                        <td colspan="2">
                            <g:submitButton name="register" class="btn btn-primary"
                                        value="${message(code: 'default.button.create.label', default: 'Register')}"/>
                        </td>
                    </tr>
                </fieldset>
                </table>
            </g:form>

        </div>
</body>
</html>

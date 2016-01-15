<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="edit.password.label"/></title>
</head>

<body>
<div id="edit-password" role="main">
    <h1><g:message code="edit.password.label"/></h1>
    <g:form controller="user" action="changeUserPassword" method="PUT" id="${user ? user.id : id}">
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <tr>
                    <td class="control-group">
                        <label><g:message code="user.username.label"/> *</label>
                    </td>
                    <td>
                        ${user.username}
                    </td>
                </tr>
                <tr>
                    <td class="control-group ${hasErrors ? 'error' : ''}">
                        <label for="password"><g:message code="user.new.password.label"/> *</label>
                    </td>
                    <td>
                        <g:passwordField name="password" value=""/>
                        <g:renderErrors bean="${user}" field="password"><span
                                class="help-inline">${errors.join('<br>')}</span></g:renderErrors>
                    </td>
                </tr>
                <tr>
                    <td class="control-group ${invalid ? 'error' : ''}">
                        <label for="newPwRepeat"><g:message code="user.new.password.repeat.label"/> *</label>
                    </td>
                    <td>
                        <g:passwordField name="newPwRepeat" value=""/>
                        <g:renderErrors bean="${user}" field="newPwRepeat"><span
                                class="help-inline">${errors.join('<br>')}</span></g:renderErrors>
                    </td>
                </tr>
            </table>
        </fieldset>
        <fieldset class="buttons">
            <input class="btn btn-success" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
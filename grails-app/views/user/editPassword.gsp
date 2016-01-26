
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
        <g:form controller="User"  action="changeOwnPassword"  method="PUT">
            <fieldset class="form">
                <table class="table-condensed table-striped">
                    <tr>
                        <td class="control-group">
                            <label><g:message code="user.username.label"/> *</label>
                        </td>
                        <td>
                            <sec:username/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="newPw"><g:message code="user.new.password.label"/> *</label>
                        </td>
                        <td>
                            <g:passwordField name="newPw"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="control-group ${invalid ? 'error' : ''}">
                            <label for="newPwRepeat"><g:message code="user.new.password.repeat.label"/> *</label>
                        </td>
                        <td>
                            <g:passwordField name="newPwRepeat"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="buttons">
                <input class="save" action="changeOwnPassword" type="submit"
                       value="${message(code: 'default.button.update.label', default: 'Update')}"/>
            </fieldset>
        </g:form>
    </div>
</body>
</html>
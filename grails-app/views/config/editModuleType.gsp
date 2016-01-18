<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 18.01.2016
  Time: 20:18
--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.config.label"/> </title>
</head>

<body>
<h1><g:message code="edit.moduleType"/></h1>
<g:form controller="config" action="updateModuleType" method="PUT">
    <g:hiddenField name="id" value="${moduleType.id}"/>
    <fieldset class="form">
        <table class="table-condensed table-striped">
            <tr>
                <td><label for="moduleType" /></td>
                <td><g:textField name="type" value="${moduleType.moduleType}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="btn btn-success" action="updateModuleType" type="submit"
                           value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                </td>
            </tr>
        </table>
    </fieldset>
</g:form>
</body>
</html>
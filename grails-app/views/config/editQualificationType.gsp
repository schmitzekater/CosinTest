<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 18.01.2016
  Time: 20:30
--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="default.config.label"/> </title>
</head>

<body>
<h1><g:message code="edit.qualificationType"/></h1>
<g:form controller="config" action="updateQualificationType" method="PUT">
    <g:hiddenField name="id" value="${qualificationType.id}"/>
    <fieldset class="form">
        <table class="table-condensed table-striped">
            <tr>
                <td><label for="type" /></td>
                <td><g:textField name="type" value="${qualificationType.type}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="btn btn-success" action="updateQualificationCategory" type="submit"
                           value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                </td>
            </tr>
        </table>
    </fieldset>
</g:form>
</body>
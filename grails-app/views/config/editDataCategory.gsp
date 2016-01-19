<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 18.01.2016
  Time: 19:58
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="default.config.label"/> </title>
</head>

<body>
<h1><g:message code="edit.dataCategory"/></h1>
<g:form controller="config" action="updateDataCategory" method="PUT">
        <g:hiddenField name="id" value="${dataCategory.id}"/>
            <fieldset class="form">
                <table class="table-condensed table-striped">
                    <tr>
                        <td><label for="category" /></td>
                        <td><g:textField name="category" value="${dataCategory.category}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input class="btn btn-success" action="updateDataCategory" type="submit"
                                               value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </g:form>
    </body>
</html>
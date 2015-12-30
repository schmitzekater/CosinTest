<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 08.12.2015
  Time: 21:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
    <div id="edit-${controllerName}" class="col-md-6" role="main">
        <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
        <g:form controller="Module" action="update" method="PUT">
            <g:hiddenField name="id" value="${module.id}"/>
            <fieldset class="form">
                <f:all bean="module">

                </f:all>
            </fieldset>
            <fieldset class="buttons">
                <input class="save" action="update" type="submit"
                       value="${message(code: 'default.button.update.label', default: 'Update')}"/>
            </fieldset>
        </g:form>
    </div>
</body>
</html>
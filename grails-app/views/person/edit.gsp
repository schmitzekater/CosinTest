<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
<h1><g:message code="default.edit.label" args="[entityName]"/></h1>
<g:form controller="person" action="update" method="PUT">
    <g:hiddenField name="id" value="${module.id}"/>
    <fieldset class="form">
        <table class="table-condensed table-striped">
            <f:with bean="person">
                <f:field property="firstName" wrapper="edit/table"/>
                <f:field property="lastName" wrapper="edit/table"/>
                <f:field property="email" wrapper="edit/table"/>
                <f:field property="department" wrapper="/edit/table"/>
            </f:with>
        </table>
    </fieldset>
    <fieldset class="buttons">
        <input class="save" action="update" type="submit"
               value="${message(code: 'default.button.update.label', default: 'Update')}"/>
    </fieldset>
</g:form>
</body>
</html>
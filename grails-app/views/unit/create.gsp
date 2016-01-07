<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body role="document">
<div id="edit-${controllerName}" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:form controller="unit" action="save">
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="unit">
                    <f:field property="unitName" wrapper="edit/table"/>
                    <f:field property="system" wrapper="edit/table"/>
                    <f:field property="modules" wrapper="edit/table"/>
                </f:with>
            </table>
        </fieldset>
        <fieldset class="buttons">
            <input class="save" action="create" type="submit"
                   value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>

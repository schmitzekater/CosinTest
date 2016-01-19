<%@ page import="de.schmitzekater.Unit" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
<div id="edit-${controllerName}" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:form controller="unit" action="update" method="PUT">
        <g:hiddenField name="version" value="${unit.version}"/>
        <g:hiddenField name="id" value="${unit.id}"/>
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="unit">
                    <f:field property="unitName" wrapper="edit/table"/>
                    <f:field property="system" wrapper="edit/table"/>
                </f:with>
            </table>
        </fieldset>
        <cos:addEditCancelButtons/>
    </g:form>
    <g:render template="/layouts/addModule" />
</div>

</body>
</html>

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
    <g:form controller="software" action="save">
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="software">
                    <f:field property="softwareName" wrapper="edit/table"/>
                    <f:field property="softwareVersion" wrapper="edit/table"/>
                    <f:field property="softwareIqOq" wrapper="edit/table"/>
                    <f:field property="softwareVendor" wrapper="edit/table"/>
                </f:with>
            </table>
        </fieldset>
        <cos:addCreateCancelButtons/>
    </g:form>
</div>
</body>
</html>

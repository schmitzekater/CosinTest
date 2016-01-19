<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body role="document">
<div id="create-${controllerName}" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:form controller="module" action="save">
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="module">
                    <f:field property="moduleName" wrapper="edit/table"/>
                    <f:field property="moduleSerial" wrapper="edit/table"/>
                    <f:field property="moduleModel" wrapper="edit/table"/>
                    <f:field property="moduleFirmware" wrapper="edit/table"/>
                    <f:field property="moduleVendor" wrapper="edit/table"/>
                    <f:field property="moduleType" wrapper="edit/table"/>
                    <f:field property="moduleConnection" wrapper="edit/table"/>
                    <f:field property="needsCalibration" wrapper="edit/table"/>
                    <f:field property="calibInterval" wrapper="edit/table"/>
                    <f:field property="calibPeriod" wrapper="edit/table"/>
                    <f:field property="productiveDate" wrapper="edit/table"/>
                </f:with>
            </table>
        </fieldset>
        <cos:addCreateCancelButtons/>
    </g:form>
</div>
</body>
</html>

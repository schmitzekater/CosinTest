<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 08.12.2015
  Time: 21:43
--%>

<%@ page import="de.schmitzekater.Qualification" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:form controller="module" action="update" method="PUT">
        <g:hiddenField name="id" value="${module.id}"/>
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
                    <f:field property="productiveDate" wrapper="edit/table" widget="edit/date"/>
                </f:with>
            </table>
        </fieldset>
        <cos:addEditCancelButtons/>
    </g:form>
<g:render template="/layouts/addQualification" model="[qualification: new de.schmitzekater.Qualification()]"/>
</body>
</html>
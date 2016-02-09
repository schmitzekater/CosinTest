<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 15.01.2016
  Time: 08:40
--%>

<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
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
    <g:form controller="computer" action="update" method="PUT">
        <g:hiddenField name="version" value="${computer.version}"/>
        <g:hiddenField name="id" value="${computer.id}"/>
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="computer">
                    <f:field property="computerName" wrapper="edit/table"/>
                    <f:field property="computerVendor" wrapper="edit/table"/>
                </f:with>
            </table>
        </fieldset>
        <cos:addEditCancelButtons/>
    </g:form>
</div>
<g:render template="/layouts/addSoftware" model="[model: computer]"/>
</body>
</html>
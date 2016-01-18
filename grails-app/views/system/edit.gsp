<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 24.10.2015
  Time: 19:32
--%>

<%@ page import="de.schmitzekater.System" contentType="text/html;charset=UTF-8" %>
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
    <g:form controller="System" action="update" method="PUT">
        <g:hiddenField name="version" value="${system.version}"/>
        <g:hiddenField name="id" value="${system.id}"/>
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="system">
                    <f:field property="systemName" wrapper="edit/table"/>
                    <f:field property="systemDepartment" wrapper="edit/table"/>
                    <f:field property="systemOwner" wrapper="edit/table"/>
                    <f:field property="processOwner" wrapper="edit/table"/>
                    <f:field property="area" wrapper="edit/table"/>
                    <f:field property="systemDataCategory" wrapper="edit/table"/>
                </f:with>
            </table>
        </fieldset>
        <fieldset class="buttons">
            <input class="btn btn-success" action="update" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>
<g:render template="/layouts/addSoftware"/>
<g:render template="/layouts/addComputer"/>
<g:render template="/layouts/addUnit"/>
</body>
</html>

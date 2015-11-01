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
    <g:set var="entityName" value="${message(code: '${propertyName}.label', default: '\${className}')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
<div class="row">
    <g:render template="systemLeft"/>

    <div id="edit-User" class="col-md-6" role="main">
        <h1><g:message code="default.edit.label" args=""/></h1>
        <g:if test="${flash.message}">
            <div class="alert alert-info" role="alert">${flash.message}</div>
        </g:if>
        <g:if test="${flash.error}">
            <div class="alert alert-danger" role="alert" style="display: block">${flash.error}</div>
        </g:if>
        <g:hasErrors>
            <ul class="errors" role="alert">
                <g:eachError var="error">
                    <li><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
        <g:form controller="System" action="update" method="PUT">
            <g:hiddenField name="version" value="${system.version}"/>
            <g:hiddenField name="id" value="${system.id}"/>
            <fieldset class="form">
                <f:with bean="system">
                    <f:field property="systemName"/>
                    <f:field property="systemDepartment"/>
                    <f:field property="systemOwner"/>
                    <f:field property="processOwner"/>
                    <f:field property="area"/>
                </f:with>
            </fieldset>
            <fieldset class="buttons">
                <input class="save" action="update" type="submit"
                       value="${message(code: 'default.button.update.label', default: 'Update')}"/>
            </fieldset>
        </g:form>
    </div>
    <g:render template="/navigation/navRight"/>
</div>
</body>
</html>

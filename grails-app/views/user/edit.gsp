<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 24.10.2015
  Time: 19:32
--%>

<%@ page import="de.schmitzekater.User" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: '${propertyName}.label', default: '\${className}')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
<div class="row">
    <div class="col-md-2">
        <h2><g:message code="default.left.sidebar"/></h2>
        <ul>
            <li><a class="home" href="/user/list"><g:message code="default.home.label"/></a></li>
            <li><g:link class="list" action="list"><g:message code="default.list.label" args="['User']"/></g:link></li>
            <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                                  args="['User']"/></g:link></li>
        </ul>
    </div>

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
        <g:form controller="User" action="update" method="PUT">
            <g:hiddenField name="version" value="${user.version}"/>
            <g:hiddenField name="id" value="${user.id}"/>
            <fieldset class="form">
                <f:with bean="user">
                    <f:field property="userId"/>
                    <f:field property="password"/>
                    <f:field property="signature"/>
                    <f:field property="person"/>
                </f:with>
            </fieldset>
            <fieldset class="buttons">
                <input class="save" action="update" type="submit"
                       value="${message(code: 'default.button.update.label', default: 'Update')}"/>
            </fieldset>
        </g:form>
    </div>

    <div class="col-md-4">
        <h2><g:message code="default.right.sidebar"/></h2>

    </div>
</div>
</body>
</html>

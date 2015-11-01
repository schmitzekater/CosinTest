<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 10.10.2015
  Time: 14:09
--%>

<%@ page import="javassist.bytecode.stackmap.TypeData" contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Systemliste</title>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: '${propertyName}.label', default: 'System')}"/>
    <title><g:message code="default.list.label" args="'System'"/></title>
</head>

<body role="document">
<div class="container">
    <div class="row">
        <g:render template="/navigation/navLeft"/>
        <div class="col-md-6"><!-- content mitte -->
            <g:if test="${flash.message}">
                <div class="alert alert-info" role="alert">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="System">
                <div class="alert alert-danger" role="alert">
                    <ul class="errors" role="alert">
                        <g:eachError bean="System" var="error">
                            <li><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </div>
            </g:hasErrors>
            <g:render template="systemList"/>

        </div>
        <g:render template="/navigation/navRight"/>
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
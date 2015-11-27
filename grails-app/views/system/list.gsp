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
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.list.label" args="'System'"/></title>
</head>

<body role="document">

<div class="col-md-6"><!-- content mitte -->

<g:render template="systemList"/>

        </div>

</body>
</html>
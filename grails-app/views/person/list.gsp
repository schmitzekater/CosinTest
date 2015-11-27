<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 10.10.2015
  Time: 14:09
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Personenliste</title>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.list.label" args="'[entityName]'"/></title>
</head>

<body role="document">
        <div class="col-md-6"><!-- content mitte -->
        <g:render template="personList"/>
        </div>>
</body>
</html>
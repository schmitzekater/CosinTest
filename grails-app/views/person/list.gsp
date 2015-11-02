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
    <g:set var="entityName" value="${message(code: 'person.label', default: 'sds')}"/>
    <title><g:message code="default.list.label" args="'[entityName]'"/></title>
</head>

<body role="document">
<div class="container">
    <div class="row">
        <g:render template="/navigation/navLeft"/>
        <div class="col-md-6"><!-- content mitte -->
        <g:render template="personList"/>

        </div>>
    <g:render template="/navigation/navRight"/>
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
%{--

Standard-Template für alle Auflistungen.
Innerhalb des Templates wird das spezielle Template aufgerufen, in dem die spezifischen Anpassungen zu finden sind.
DRY!

--}%


<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.list.label" args="'[entityName]'"/></title>
</head>

<body role="document">
<div id="list-${controllerName}" class="col-md-6" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:render template="/layouts/messagesTop"/>                                          <!-- Top of page for messages / errors -->
    <!-- main content for page -->
    <g:render template="${controllerName}List" />
</div>

</body>
</html>
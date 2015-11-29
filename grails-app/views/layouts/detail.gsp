<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 29.11.2015
  Time: 13:09
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <g:set var="entityName" value="${controllerName.capitalize()}"/>
        <title><g:message code="default.show.label" args="[entityName]"/></title>
        <meta name="layout" content="main" />
    </head>

    <body role="document">
        <!-- Main Block start -->
        <div id="detail-${entityName}" role="main">
            <h1><g:message code="default.show.label" args="[entityName]"/></h1>
            <!-- main content for page -->
            <g:render template="${controllerName}Detail" />
        </div>
    </body>
</html>
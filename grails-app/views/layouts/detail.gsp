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
        <title><g:message code="default.detail.label" args="[entityName]"/></title>
        <meta name="layout" content="main" />
    </head>

    <body role="document">
        <!-- Main Block start -->
    <div class="panel panel-default" role="main">
        <div id="detail-${entityName}" class="panel-heading">
            <h4><g:message code="default.detail.label" args="[entityName]"/></h4>
        </div>

        <div class="panel-body">
            <!-- main content for page -->
            <g:render template="${controllerName}Detail"/>
        </div>
        </div>
    </body>
</html>
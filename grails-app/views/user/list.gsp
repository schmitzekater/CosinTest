<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 10.10.2015
  Time: 14:09
--%>

<%@ page import="de.schmitzekater.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.list.label" args="'[entityName]'"/></title>
    <g:set var="entityName"
           value="${controllerName.capitalize()}"/> <!-- Leider wird die Variable nicht übernommen aus main.gsp. Auch nicht über anderen Scope -->
</head>

<body role="document">
    <!-- Main Block start -->
        <div id="list-User" class="col-md-6" role="main">
            <h1><g:message code="default.list.label" args="[entityName]"/></h1>
            <g:render
                    template="/layouts/messagesTop"/>                                          <!-- Top of page for messages / errors -->
            <!-- main content for page -->
            <g:render template="userList"/>
        </div>                                                                          <!-- Main Block end -->
</body>
</html>
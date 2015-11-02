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
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.list.label" args="'[entityName]'"/></title>
</head>

<body role="document">
<div class="container"><!-- Container for all content -->
    <div class="row"><!-- First Row -->
    <g:render template="/navigation/navLeft"/>                                  <!-- Sidebar Left -->
    <!-- Main Block start -->
        <div id="list-User" class="col-md-6" role="main">
            <h1><g:message code="default.list.label" args="[entityName]"/></h1>
            <g:render
                    template="userTop"/>                                          <!-- Top of page for messages / errors -->
            <!-- main content for page -->
            <g:render template="userList"/>
        </div>                                                                          <!-- Main Block end -->
    <g:render template="/navigation/navRight"/>                                 <!-- Sidebar Right -->
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
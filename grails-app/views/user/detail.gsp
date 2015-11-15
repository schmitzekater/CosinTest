<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.11.2015
  Time: 19:38
--%>

<%@ page import="de.schmitzekater.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.show.label" args="'[entityName]'"/></title>
</head>

<body role="document">
<div class="container"><!-- Container for all content -->
    <div class="row"><!-- First Row -->
    <g:render template="/navigation/navLeft"/>                                  <!-- Sidebar Left -->
    <!-- Main Block start -->
        <div id="detail-User" class="col-md-6" role="main">
            <h1><g:message code="default.show.label" args="[entityName]"/></h1>
            <g:render
                    template="userTop"/>                                          <!-- Top of page for messages / errors -->
            <!-- main content for page -->
            <table class="table table-striped">
                <thead>
                <tr>
                    <td colspan="2">Details for user ${user.userId}</td>
                </tr>
                </thead>
                <tbody>
                <f:display bean="user" property="userId" wrapper="user"><tr><td>${label}</td><td>${value}</td>
                </tr></f:display>
                <f:display bean="user" property="signature" wrapper="detail"><tr><td>${label}</td><td>${value}</td>
                </tr></f:display>
                <f:display bean="user" property="person.id"
                           wrapper="detail"><tr><td>Person-${label}</td><td>${value} (${user.person.lastName}, ${user.person.firstName})</td>
                </tr></f:display>
                <f:display bean="user" property="dateCreated" wrapper="detail"><tr><td>${label}</td><td>${value}</td>
                </tr></f:display>
                <f:display bean="user" property="isAdmin" wrapper="detail"><tr><td>${label}</td><td>${value}</td>
                </tr></f:display>
                </tbody>
            </table>
        </div>                                                                          <!-- Main Block end -->
    <g:render template="/navigation/navRight"/>                                 <!-- Sidebar Right -->
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
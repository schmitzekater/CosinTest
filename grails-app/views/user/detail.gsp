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
            <h1><g:message code="default.show.label" args="[entityName]"/> ${user.userId}</h1>

            <g:render
                    template="userTop"/>                                          <!-- Top of page for messages / errors -->
            <!-- main content for page -->
            <table class="table table-striped">

                <tbody>
                <f:with bean="user">
                    <f:display property="userId"/>
                    <f:display property="signature"/>
                    <f:display property="person.id"/>
                    <f:display property="dateCreated"/>
                    <f:display property="isAdmin"/>
                </f:with>
                </tbody>
            </table>
            <g:form controller="user" id="${user.id}">
                <g:actionSubmit action="edit" class="btn btn-primary"
                                value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
            </g:form>
        </div>                                                                          <!-- Main Block end -->
    <g:render template="/navigation/navRight"/>                                 <!-- Sidebar Right -->
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
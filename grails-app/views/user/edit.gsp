<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 24.10.2015
  Time: 19:32
--%>

<%@ page import="de.schmitzekater.User" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
<div class="container"><!-- Container for all content -->
    <div class="row"><!-- First Row -->
    <g:render template="/navigation/navLeft"/>                                      <!-- Sidebar Left -->
    <!-- Main Block start -->
        <div id="edit-User" class="col-md-6" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
            <g:render
                    template="userTop"/>                                                 <!-- Top of page for messages / errors -->
        <!-- main content for page -->
            <g:form controller="User" action="update" method="PUT">
                <g:hiddenField name="version" value="${user.version}"/>
                <g:hiddenField name="id" value="${user.id}"/>
                <fieldset class="form">
                    <f:with bean="user">
                        <f:field property="userId"/>
                        <f:field property="password"/>
                        <f:field property="signature"/>
                        <f:field property="person"/>
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" action="update" type="submit"
                           value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                </fieldset>
            </g:form>
            <g:render template="userList" model="[users: User.getAll(), numUser: User.count]"/>
        </div>                                                                          <!-- Main Block end -->
    <g:render template="/navigation/navRight"/>                                     <!-- Sidebar Right -->
    </div> <!-- row -->
</div><!-- container -->
</body>
</html>

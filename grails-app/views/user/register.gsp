<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 07.11.2015
  Time: 11:42
--%>

<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body role="document">
<div class="container"><!-- Container for all content -->
    <div class="row"><!-- First Row -->
    <g:render template="/navigation/navLeft"/>                                      <!-- Sidebar Left -->
    <!-- Main Block start -->
        <div id="create-User" class="col-md-6" role="main">
            <h1><g:message code="default.create.label" args="[entityName]"/></h1>
            <g:render
                    template="userTop"/>                                                 <!-- Top of page for messages / errors -->
        <!-- main content for page -->
            <g:form action="register" controller="user">
                <fieldset class="form">
                   %{-- <f:with bean="user">
                        <f:field property="userId"/>
                        <f:field property="password"/>
                        <f:field property="signature"/>
                    </f:with>
                    <f:with bean="person">
                        <f:field property="firstName"/>
                        <f:field property="lastName"/>
                        <f:field property="email"/>
                    </f:with>--}%
                    <div class="fieldcontain required-indicator">
                        <label for="userId">UserId</label>
                        <g:textField name="userId" value="${user.userId}"/>
                    </div>
                    <div class="fieldcontain required-indicator">
                        <label for="password">Password</label>
                        <g:textField name="password" value="${user?.password}"/>
                    </div>
                    <div class="fieldcontain required-indicator">
                        <label for="passwordRepeat">Password Repeat</label>
                        <g:passwordField name="passwordRepeat" value="${user?.passwordRepeat}"/>
                    </div>

                    <div class="fieldcontain required-indicator">
                        <label for="signature">Signature</label>
                        <g:textField name="signature" value="${user?.signature}"/>
                    </div>
                    <div class="fieldcontain required-indicator">
                        <label for="signatureRepeat">Signature</label>
                        <g:textField name="signatureRepeat" value="${user?.signatureRepeat}"/>
                    </div>
                    <div class="fieldcontain required-indicator">
                        <label for="firstName">First Name</label>
                        <g:textField name="firstName" value="${user?.firstName}"/>
                    </div>
                    <div class="fieldcontain required-indicator">
                        <label for="lastName">Last Name</label>
                        <g:textField name="lastName" value="${user?.lastName}"/>
                    </div>

                    <div class="fieldcontain required-indicator">
                        <label for="email">Email</label>
                        <g:textField name="email" value="${user?.email}"/>
                    </div>
                </fieldset>
                <div class="form-actions">
                    <g:submitButton name="register" class="btn btn-primary"
                                    value="${message(code: 'default.button.create.label', default: 'Register')}"/>
                </div>
            </g:form>
        </div>                                                                          <!-- Main Block end -->
    <g:render template="/navigation/navRight"/>                                     <!-- Sidebar Right -->
    </div> <!-- row -->
</div><!-- container -->
</body>
</html>

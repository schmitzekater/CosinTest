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
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
    <!-- Main Block start -->
        <div id="edit-User" class="col-md-6" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]"/></h1>

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

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 15.01.2016
  Time: 08:40
--%>

<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body role="document">
<div id="edit-${controllerName}" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:form controller="computer" action="save">
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="computer">
                    <f:field property="computerName" wrapper="edit/table"/>
                    <f:field property="computerVendor" wrapper="edit/table"/>
                    <!-- TODO: System und Rolle einbauen -->
                </f:with>
            </table>
        </fieldset>
        <cos:addCreateCancelButtons/>
    </g:form>
</div>
</body>
</html>

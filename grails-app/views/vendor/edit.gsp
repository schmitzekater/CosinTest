<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 14.01.2016
  Time: 21:38
--%>

<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
<div id="edit-${controllerName}" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:form controller="vendor" action="update" method="PUT">
        <g:hiddenField name="version" value="${vendor.version}"/>
        <g:hiddenField name="id" value="${vendor.id}"/>
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="vendor">
                    <f:field property="name" wrapper="edit/table"/>
                    <f:field property="url" wrapper="edit/table"/>
                    <f:field property="address.streetOne" wrapper="edit/table"/>
                    <f:field property="address.streetTwo" wrapper="edit/table"/>
                    <f:field property="address.zip" wrapper="edit/table"/>
                    <f:field property="address.city" wrapper="edit/table"/>
                    <f:field property="address.county" wrapper="edit/table"/>
                    <f:field property="address.country" wrapper="edit/table/country"/>
                </f:with>
            </table>
        </fieldset>
        <fieldset class="buttons">
            <input class="btn btn-primary" action="update" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>                                                                          <!-- Main Block end -->
</body>
</html>
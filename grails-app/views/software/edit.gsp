<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 08.12.2015
  Time: 21:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
    <div id="edit-${controllerName}" role="main">
        <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
        <g:form controller="Software" action="update" method="PUT">
            <g:hiddenField name="id" value="${software.id}"/>
            <fieldset class="form">
                <table class="table-condensed table-striped">
                    <f:with bean="software">
                        <f:field property="softwareName" wrapper="edit/table"/>
                        <f:field property="softwareVersion" wrapper="edit/table"/>
                        <f:field property="softwareVendor" wrapper="edit/table"/>
                        <f:field property="system" wrapper="edit/table"/>
                    </f:with>
                </table>
            </fieldset>
            <cos:addEditCancelButtons/>
        </g:form>
        <sec:access expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE')">
            <hr/>
            <g:render template="/layouts/addQualification"/>
        </sec:access>
    </div>
</body>
</html>
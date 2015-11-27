<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 24.10.2015
  Time: 19:32
--%>

<%@ page import="de.schmitzekater.System" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">

    <div id="edit-User" class="col-md-6" role="main">
        <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
        <g:form controller="System" action="update" method="PUT">
            <g:hiddenField name="version" value="${system.version}"/>
            <g:hiddenField name="id" value="${system.id}"/>
            <fieldset class="form">
                <f:with bean="system">
                    <f:field property="systemName"/>
                    <f:field property="systemDepartment"/>
                    <f:field property="systemOwner"/>
                    <f:field property="processOwner"/>
                    <f:field property="area"/>
                </f:with>
            </fieldset>
            <fieldset class="buttons">
                <input class="save" action="update" type="submit"
                       value="${message(code: 'default.button.update.label', default: 'Update')}"/>
            </fieldset>
        </g:form>
    </div>

</body>
</html>

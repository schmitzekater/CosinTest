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
<div id="edit-${controllerName}" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:form controller="department" action="update" method="PUT">
        <g:hiddenField name="version" value="${department.version}"/>
        <g:hiddenField name="id" value="${department.id}"/>
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="department">
                    <f:field property="departmentName" wrapper="edit/table"/>
                    <f:field property="supervisor" wrapper="edit/table"  widget="edit/queries/person/supervisor"/>
                </f:with>
            </table>
        </fieldset>
        <fieldset class="buttons">
            <input class="save" action="update" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>

</body>
</html>

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
    <g:form controller="User" action="createUser">
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <f:with bean="user">
                    <f:field property="username" wrapper="edit/table"/>
                    <f:field property="password" wrapper="edit/table/secret"/>
                    <f:field property="signature" wrapper="edit/table/secret"/>
                    <f:field property="person" wrapper="/edit/table" widget="edit/queries/person"/>
                    <tr>
                        <td><label for="userRoleGroup"><g:message code="user.roleGroup.label"/></label></td>
                        <td><g:select from="${RoleGroup.findAll()}" optionKey="id" optionValue="displayString"
                                      noSelection="${['null': '<N/A>']}"
                                      name="userRoleGroup"/></td>
                    </tr>
                </f:with>
            </table>
        </fieldset>
        <fieldset class="buttons">
            <input class="btn btn-primary" type="submit"
                   value="${message(code: 'default.button.create.label', default: 'Create')}"/>
            <input class="btn btn-danger" type="button" onclick="window.history.back()"
                   value="${message(code: 'default.cancel.button', default: 'Cancel')}"
                   title="${message(code: 'default.cancel.button', default: 'Cancel')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>

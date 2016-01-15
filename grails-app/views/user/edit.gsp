<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 24.10.2015
  Time: 19:32
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
            <g:form controller="User" action="update" method="PUT">
                <g:hiddenField name="version" value="${user.version}"/>
                <g:hiddenField name="id" value="${user.id}"/>
                <fieldset class="form">
                    <table class="table-condensed table-striped">
                        <f:with bean="user">
                            <f:field property="username" wrapper="edit/table"/>
                            <f:field property="password" wrapper="edit/table/secret"/>
                            <f:field property="signature" wrapper="edit/table/secret"/>
                            <tr>
                                <td><label for="userRoleGroup"><g:message code="user.roleGroup.label"/></label></td>
                                <td><g:select from="${RoleGroup.findAll()}" optionKey="id" optionValue="displayString"
                                              noSelection="${['null': '<N/A>']}" value="${user.getAuthorities()}"
                                              name="userRoleGroup" multiple="false"/></td>
                            </tr>
                        </f:with>
                    </table>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" action="update" type="submit"
                           value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                </fieldset>
            </g:form>
        </div>                                                                          <!-- Main Block end -->
    </body>
</html>

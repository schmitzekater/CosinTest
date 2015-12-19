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
    <div id="edit-${controllerName}" class="col-md-6" role="main">
        <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
        <g:form controller="Software" action="update" method="PUT">
            <g:hiddenField name="id" value="${software.id}"/>
            <fieldset class="form">
                <f:with bean="software">
                    <f:field property="softwareName"/>
                    <f:field property="softwareVersion"/>
                    <f:field property="softwareVendor"/>
                    <f:field property="system"/>
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
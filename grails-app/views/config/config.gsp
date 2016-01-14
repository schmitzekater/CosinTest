<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 13.01.2016
  Time: 22:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="default.config.label"/></title>
</head>


<body role="document">
<div id="edit-${controllerName}" role="main">
    <h1><g:message code="default.config.label"/></h1>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="QualificationType.label"/></h3>
        </div>
        <g:render template="qualificationTypesList" model="${qualificationTypes}"/>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="ModuleType.label"/> </h3>
        </div>
        <g:render template="moduleTypesList" model="${moduleTypes}"/>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="ConnectionType.label"/> </h3>
        </div>
        <g:render template="connectionTypesList" model="${connectionTypes}"/>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="ComputerRole.label"/> </h3>
        </div>
        <g:render template="computerRolesList" model="${computerRoles}"/>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="DataCategory.label"/> </h3>
        </div>
        <g:render template="dataCategoriesList" model="${dataCategories}"/>
    </div>
</div>
<asset:javascript src="clearInputs.js"/>
</body>
</html>
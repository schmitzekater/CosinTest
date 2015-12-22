<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 22.12.2015
  Time: 20:28
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
            <h3 class="panel-title"><g:message code="QualificationType.label"/> </h3>
        </div>
        <div class="panel-body"  id="qualificationTypes">
            <g:form>
                <g:textField name="type" id="QualificationType" value="QualificationType"/>
                <g:submitToRemote value="+" url="[action:'addQualificationType']"  update="qualificationTypes" onSuccess="clearQualificationTypes" onLoading="showSpinner(true)" onComplete="showSpinner(false)"/>
                <g:img id="spinner" style="display: inline" uri="/images/spinner.gif"/>
            </g:form>
            <ul>
                <g:each var="qt" in="${qualificationTypes}">
                    <li>${qt.toString()}</li>
                </g:each>
            </ul>
        </div>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="ModuleType.label"/> </h3>
        </div>
        <div class="panel-body" id="moduleTypes">
            <ul>
                <g:each var="mt" in="${moduleTypes}">
                    <li>${mt.toString()}</li>
                </g:each>
            </ul>
        </div>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="ConnectionType.label"/> </h3>
        </div>
        <div class="panel-body">
            <ul>
                <g:each var="ct" in="${connectionsTypes}">
                    <li>${ct.toString()}</li>
                </g:each>
            </ul>
        </div>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="ComputerRole.label"/> </h3>
        </div>
        <div class="panel-body">
            <ul>
                <g:each var="cr" in="${computerRoles}">
                    <li>${cr.toString()}</li>
                </g:each>
            </ul>
        </div>
        <div class="panel-heading">
            <h3 class="panel-title"><g:message code="DataCategory.label"/> </h3>
        </div>
        <div class="panel-body">
            <ul>
                <g:each var="dc" in="${dataCategories}">
                    <li>${dc.toString()}</li>
                </g:each>
            </ul>
        </div>
    </div>
</div>
</body>
<asset:javascript src="jquery-2.1.3.js"/>
</html>
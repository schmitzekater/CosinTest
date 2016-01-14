<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 14.01.2016
  Time: 09:48
--%>

<%@ page import="de.schmitzekater.AuditLogEvent" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="qualification.list.label"/></title>
</head>

<body role="document">
<g:render template="/layouts/addPaginateButtons"/>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <g:sortableColumn property="qualification.id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="qualification.qualificationDate"
                          title="${message(code: 'qualification.qualificationDate.label', default: 'Date')}"/>
        <g:sortableColumn property="module.moduleName" title="${message(code: 'module.moduleName.label', default: 'Actor')}"/>
        <g:sortableColumn property="module.moduleSerial"
                          title="${message(code: 'module.moduleSerial.label', default: 'Event')}"/>
        <g:sortableColumn property="qualification.qualificationType"
                          title="${message(code: 'QualificationType.label', default: 'Class')}"/>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each var="qualification" in="${model}">
        <tr>
            <f:with bean="${qualification}">
                <f:display property="qualification.id" wrapper="list/link"/>
                <f:display property="qualificationDate" wrapper="list/date"/>
                <f:display property="module.moduleName" wrapper="list"/>
                <f:display property="module.moduleSerial" wrapper="list"/>
                <f:display property="qualification.qualificationType" wrapper="list"/>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: qualification.qualification]"/>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
</body>
</html>
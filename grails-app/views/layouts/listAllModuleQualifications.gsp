<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 14.01.2016
  Time: 09:48
--%>

<%@ page import="de.schmitzekater.AuditLogEvent" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="qualification.list.label"/></title>
</head>

<body role="document">
<g:render template="/layouts/addPaginateButtons"/>
<div class="form-group col-lg-6 col-lg-offset-2">
    <div class="panel-primary">
        <div class="panel-heading">
            <g:message code="filter.list"/>
        </div>

        <div class="panel-body">
            <g:form action="listAllModuleQualifications">
                <table>
                    <tr>
                        <td>From:</td>
                        <td><g:datePicker name="dateFrom" value="${params.dateFrom}" precision="day"/></td>
                    </tr>
                    <tr>
                        <td>To:</td>
                        <td><g:datePicker name="dateTo" value="${params.dateTo}" precision="day"/></td>
                    </tr>
                    <tr>
                        <td>Max:</td>
                        <td><g:select name="max" from="[10, 25, 50]" value="${params.max}"/></td>
                    </tr>
                    <td colspan="2"><input type="submit" value="Search" class="btn btn-primary"></td>
                </table>
            </g:form>
        </div>
    </div>
</div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <g:sortableColumn property="qualificationDate"
                          title="${message(code: 'qualification.qualificationDate.label', default: 'Date')}"/>
        <g:sortableColumn property="qualificationObject"
                          title="${message(code: 'module.moduleName.label', default: 'Actor')}"/>
        <g:sortableColumn property="comment"
                          title="${message(code: 'Qualification.comment.label', default: 'Event')}"/>
        <g:sortableColumn property="qualification.qualificationType"
                          title="${message(code: 'QualificationType.label', default: 'Class')}"/>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each var="qualification" in="${model}">
        <tr>
            <td><g:formatDate format="yyyy-MM-dd" date="${qualification.qualificationDate}"/></td>
            <td><g:link controller="module" action="detail"
                        id="${qualification.qualificationObject.id}">${qualification.qualificationObject}</g:link></td>
            <td>${qualification.comment}</td>
            <td>${qualification.qualificationType}</td>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
</body>
</html>
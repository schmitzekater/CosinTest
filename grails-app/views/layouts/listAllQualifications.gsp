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
<g:if test="${params.int('max') < count}">
    <div class="paginateButtons">
        <g:message code="default.page.label"/> <g:paginate total="${count}" prev="&lt;" next="&gt;"
                                                           params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
    </div>
</g:if>
<div class="form-group col-lg-6 col-lg-offset-2">
    <div class="panel-primary">
        <div class="panel-heading">
            <g:message code="filter.list"/>
        </div>
<g:form action="${actionName}">
    <div class="panel-body">
                <table>
                    <tr>
                        <td><g:message code="date.dateFrom"/></td>
                        <td><g:datePicker name="dateFrom" value="${params.dateFrom}" precision="day"
                                          relativeYears="[-25..1]"/></td>
                    </tr>
                    <tr>
                        <td><g:message code="date.dateTo"/></td>
                        <td><g:datePicker name="dateTo" value="${params.dateTo}" precision="day"
                                          relativeYears="[-25..1]"/></td>
                    </tr>
                    <tr>
                        <td><g:message code="entries.max"/></td>
                        <td><g:select name="max" from="[10, 25, 50]" value="${params.max}"/></td>
                    </tr>
                    <td colspan="2"><input type="submit" value="${message(code: 'filter.list.label')}" class="btn btn-primary"></td>
                </table>
        </div>
    </div>
</div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <g:sortableColumn property="qualificationDate"
                          title="${message(code: 'qualification.qualificationDate.label', default: 'Date')}"
                          params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
        <g:sortableColumn property="qualificationObject"
                          title="${message(code: 'module.moduleName.label', default: 'Name')}"
                          params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
        <g:sortableColumn property="comment"
                          title="${message(code: 'qualification.comment.label', default: 'Comment')}"
                          params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
    <g:sortableColumn property="qualificationType"
                      title="${message(code: 'QualificationType.label', default: 'QualificationType')}"
                      params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
        <th></th>
        <th></th>

    </tr>
    </thead>
</g:form>
    <tbody>
    <g:each var="qualification" in="${model}">
        <tr>
            <td><g:formatDate format="yyyy-MM-dd" date="${qualification.qualificationDate}"/></td>
            <td><g:link action="detail"
                        id="${qualification.qualificationObject.id}">${qualification.qualificationObject}</g:link></td>
            <td>${qualification.comment}</td>
            <td>${qualification.qualificationType}</td>
         <td>
            <g:if test="${qualification.attachment}">
                <a href="${qualification.attachment.absolutePath}" target="_blank" >Link</a>
            </g:if>
             <g:else>
                 --
             </g:else>
         </td>
        </tr>
    </g:each>
    </tbody>
</table>
<g:if test="${params.int('max') < count}">
    <div class="paginateButtons">
        <g:message code="default.page.label"/> <g:paginate total="${count}" prev="&lt;" next="&gt;"
                                                           params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
    </div>
</g:if>
</body>
</html>
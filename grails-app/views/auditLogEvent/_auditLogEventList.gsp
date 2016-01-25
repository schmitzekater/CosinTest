<%@ page import="de.schmitzekater.AuditLogEvent" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="auditTrail.label"/></title>
</head>

<body role="document">

<g:render template="/layouts/addPaginateButtons"/>
<div class="form-group col-lg-6 col-lg-offset-2">
<g:form action="list" controller="auditLogEvent">
    <div class="panel-primary">
        <div class="panel-heading">
            <g:message code="filter.list"/>
        </div>


        <div class="panel-body">
                <table class="table table-condensed">
                    <tr>
                        <td><g:message code="date.dateFrom"/></td>
                        <td><g:datePicker name="dateFrom" value="${params.dateFrom}" precision="day" relativeYears="[-15..0]"/></td>
                    </tr>
                    <tr>
                        <td><g:message code="date.dateTo"/></td>
                        <td><g:datePicker name="dateTo" value="${params.dateTo}" precision="day" relativeYears="[-15..0]"/></td>
                    </tr>
                    <tr>
                        <td><g:message code="entries.max"/></td>
                        <td><g:select name="max" from="[10, 25, 50, 100]" value="${params.max}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="${message(code: 'filter.list.label')}" class="btn btn-primary"></td>
                    </tr>
                </table>
        </div>
    </div>
</div>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'auditlogEvent.dateCreated.label', default: 'Date')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <g:sortableColumn property="actor" title="${message(code: 'auditlogEvent.actor.label', default: 'Actor')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <g:sortableColumn property="eventName"
                              title="${message(code: 'auditlogEvent.eventName.label', default: 'Event')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <g:sortableColumn property="className"
                              title="${message(code: 'auditlogEvent.className.label', default: 'Class')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            %{-- <g:sortableColumn property="persistedObjectId"
                               title="${message(code: 'auditlogEvent.ObjectId.label', default: 'Object ID')}"/>--}%
            <g:sortableColumn property="propertyName"
                              title="${message(code: 'auditlogEvent.propertyName.label', default: 'Property')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <g:sortableColumn property="oldValue"
                              title="${message(code: 'auditlogEvent.oldValue.label', default: 'Old')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <g:sortableColumn property="newValue"
                              title="${message(code: 'auditlogEvent.newValue.label', default: 'New')}"
                              params="[dateFrom: params.dateFrom, dateTo: params.dateTo, max: params.max, offset: params.offset]"/>
            <th></th>
        </tr>
    </thead>
    <tbody>
    <g:each var="auditLogEvent" in="${model}">
        <tr>
            <f:with bean="${auditLogEvent}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="dateCreated" wrapper="list/auditTrailEvent/date"/>
                <f:display property="actor" wrapper="list/auditTrailEvent"/>
                <f:display property="eventName" wrapper="list/auditTrailEvent"/>
                <f:display property="className" wrapper="list/auditTrailEvent/link"/>
            %{--<f:display property="persistedObjectId" wrapper="list/auditTrailEvent"/>--}%
                <f:display property="propertyName" wrapper="list/auditTrailEvent"/>
                <f:display property="oldValue" wrapper="list/auditTrailEvent"/>
                <f:display property="newValue" wrapper="list/auditTrailEvent"/>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: auditLogEvent]"/>
        </tr>
    </g:each>
    </tbody>
</table>

</g:form>
<g:render template="/layouts/addPaginateButtons"/>
</body>
</html>
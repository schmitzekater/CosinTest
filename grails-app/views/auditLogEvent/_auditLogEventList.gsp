<%@ page import="de.schmitzekater.AuditLogEvent" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="auditTrail.label"/></title>
</head>

<body role="document">
<div class="form-group">
    <div class="panel-primary">
        <div class="panel-heading">
            <g:message code="filter.list"/>
        </div>

        <div class="panel-body">
            <g:form action="list">
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
                    <td colspan="2"><input type="submit" value="Search"></td>
                </table>
            </g:form>
        </div>
    </div>
</div>
<g:render template="/layouts/addPaginateButtons"/>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'auditlogEvent.dateCreated.label', default: 'Date')}"/>
            <g:sortableColumn property="actor" title="${message(code: 'auditlogEvent.actor.label', default: 'Actor')}"/>
            <g:sortableColumn property="eventName"
                              title="${message(code: 'auditlogEvent.eventName.label', default: 'Event')}"/>
            <g:sortableColumn property="className"
                              title="${message(code: 'auditlogEvent.className.label', default: 'Class')}"/>
            %{-- <g:sortableColumn property="persistedObjectId"
                               title="${message(code: 'auditlogEvent.ObjectId.label', default: 'Object ID')}"/>--}%
            <g:sortableColumn property="propertyName"
                              title="${message(code: 'auditlogEvent.propertyName.label', default: 'Property')}"/>
            <g:sortableColumn property="oldValue"
                              title="${message(code: 'auditlogEvent.oldValue.label', default: 'Old')}"/>
            <g:sortableColumn property="newValue"
                              title="${message(code: 'auditlogEvent.newValue.label', default: 'New')}"/>
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
<g:render template="/layouts/addPaginateButtons"/>
</body>
</html>
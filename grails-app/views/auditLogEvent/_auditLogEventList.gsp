<%@ page import="de.schmitzekater.AuditLogEvent" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="auditTrail.label"/></title>
</head>


    <div class="container-fluid">
        <g:render template="/layouts/addPaginateButtons"/>
        <div class="row-fluid">
            <div class="form-group col-lg-6 col-lg-offset-2">

                <div class="panel-primary">
                    <div class="panel-heading">
                        <g:message code="filter.list"/>
                    </div>

<g:form action="list" controller="auditLogEvent">
                    <div class="panel-body">
                        <table class="table table-condensed">
                            <tr>
                                <td><g:message code="date.dateFrom"/></td>
                                <td><g:datePicker name="dateFrom" value="${params.dateFrom}" precision="day"
                                                  relativeYears="[-15..0]"/></td>
                            </tr>
                            <tr>
                                <td><g:message code="date.dateTo"/></td>
                                <td><g:datePicker name="dateTo" value="${params.dateTo}" precision="day"
                                                  relativeYears="[-15..0]"/></td>
                            </tr>
                            <tr>
                                <td><g:message code="entries.max"/></td>
                                <td><g:select name="max" from="[10, 25, 50, 100]" value="${params.max}"/></td>
                            </tr>
                                <td colspan="2"><input type="submit" value="${message(code: 'filter.list.label')}"
                                                       class="btn btn-primary"></td>
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
                <g:sortableColumn property="actor"
                                  title="${message(code: 'auditlogEvent.actor.label', default: 'Actor')}"
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

</g:form>
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
                        <g:if test="${auditLogEvent.properties.propertyName == ('dataFlow') || auditLogEvent.properties.propertyName == ('attachment')}">
                            <f:display property="oldValue" wrapper="list/auditTrailEvent/file"/>
                            <f:display property="newValue" wrapper="list/auditTrailEvent/file"/>
                        </g:if>
                        <g:else>
                            <f:display property="oldValue" wrapper="list/auditTrailEvent"/>
                            <f:display property="newValue" wrapper="list/auditTrailEvent"/>
                        </g:else>
                    </f:with>
                    <td>
                        <g:render template="/layouts/editInfoButtons" model="[model: auditLogEvent]"/>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
<g:render template="/layouts/addPaginateButtons"/>

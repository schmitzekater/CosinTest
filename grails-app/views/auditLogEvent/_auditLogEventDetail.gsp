<%@ page import="de.schmitzekater.AuditLogEvent" %>
<html>
<head>
    <meta name="layout" content="config"/>
    <title><g:message code="auditTrail.label"/></title>
</head>

<body role="document">
    <table class="table table-striped">
        <tbody>
        <f:with bean="auditLogEventInstance">
            <f:display property="id" wrapper="detail"/>
            <f:display property="actor" wrapper="detail"/>
            <f:display property="uri" wrapper="detail"/>
            <f:display property="className" wrapper="detail/link/auditTrailEvent"/>
        %{--<f:display property="persistedObjectId" wrapper="detail"/>--}%
            <f:display property="persistedObjectVersion" wrapper="detail"/>
            <f:display property="eventName" wrapper="detail"/>
            <f:display property="propertyName" wrapper="detail"/>
            <f:display property="oldValue" wrapper="detail"/>
            <f:display property="newValue" wrapper="detail"/>
            <f:display property="dateCreated" wrapper="detail"/>
        </f:with>
        </tbody>
    </table>
</body>
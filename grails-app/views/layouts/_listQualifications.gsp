
<table class="table-condensed table-responsive">
    <thead>
    <tr>
        <th><g:message code="qualification.qualificationDate.label"/></th>
        <th><g:message code="qualification.qualificationType.label"/></th>
        <th><g:message code="qualification.comment.label"/></th>
        <th><g:message code="qualification.qualificationAttachment.label"/></th>
    </tr>
    </thead>
    <tbody>
    <g:each var="qualification" in="${model}">
        <tr>
        <f:with bean="${qualification}">
           <f:display property="qualificationDate" wrapper="list/date"/>
            <f:display property="qualificationType" wrapper="list"/>
            <f:display property="comment" wrapper="list"/>
            <f:display property="attachment" wrapper="list/link/file"/>
        </f:with>
        </tr>
    </g:each>
    </tbody>
</table>


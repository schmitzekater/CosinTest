<td>
    <g:if test="${controllerName.compareToIgnoreCase("AuditLogEvent") != 0}">
        <sec:link action="edit" id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
            <span class="glyphicon glyphicon-pencil" style="color: orange" aria-hidden="true" title='<g:message
                code="edit.${controllerName}"/>'>
        </sec:link>
    </g:if>
    <g:link action="detail" id="${model.id}">
        <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
            code="info.${controllerName}"/>'>
    </g:link>
    <g:if test="${controllerName.compareToIgnoreCase("User") == 0}">
        <g:render template="/layouts/userEditButtons" model="[model: model]"></g:render>
    </g:if>
</td>
<dt>${message(code: 'computer.computerRole.label', default: 'Role')} (${message(code: 'system.name.label', default: 'System')})</dt>
<dd><g:each var="systemRole" in="${computer.getSystemRoles()}">
    <g:if test="${controllerName.compareToIgnoreCase('Computer')==0}">
        ${systemRole.computerRole.toString()} <g:link action="detail" controller="system" id="${systemRole.system.id}">(${systemRole.system.toString()})</g:link>
        <br/>
    </g:if>
    <g:else>
        ${systemRole.computerRole.toString()}<br/>
    </g:else>
</g:each>
</dd>
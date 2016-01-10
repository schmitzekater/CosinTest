<dt><g:message code="user.roleGroup.label"/></dt>
<g:each var="roleGroup" in="${user.getAuthorities()}">
    <dd>${roleGroup.displayString} </dd>
</g:each>


<div class="nav" role="navigation">
    <ul class="list-group">
        <li class="list-group-item active">
            <g:message code="default.left.sidebar"/>
        </li>
        <sec:access expression="hasRole('ROLE_DELETE')">
            <li class="list-group-item">
                <g:link action="config" controller="config">
                    <g:message code="config.edit.strings"/>
                </g:link>
            </li>
        </sec:access>
        <li class="list-group-item">
            <g:link controller="auditLogEvent" action="list">
                <g:message code="auditTrail.list.label"/>
            </g:link>
        </li>
        <li class="list-group-item">
            <g:link controller="config" action="about">
                <g:message code="application.details"/>
            </g:link>
        </li>
        <li class="list-group-item">
            <a class="home" href="/">
                <span class="glyphicon glyphicon-home" aria-hidden="true">&nbsp</span><g:message
                    code="default.home.label"/>
            </a>
        </li>
    </ul>
</div>

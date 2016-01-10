    <sec:ifLoggedIn>
        <div class="panel panel-success">
            <div class="panel-heading">
                  <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
            </div>
            <div class="panel-body">
                <p><g:message code="default.right.welcome.loggedin"/> <sec:username/></p>
                <p><g:link controller="logout"><g:message code="default.user.logout"/></g:link></p>
                <p><g:link  controller="user" action="editPassword" ><g:message code="edit.password.label"/></g:link></p>
                <p><sec:access expression="hasRole('ROLE_DELETE')"> You can delete</sec:access></p>
                <p><sec:access expression="hasRole('ROLE_CREATE')"> You can create</sec:access></p>
                <p><sec:access expression="hasRole('ROLE_EDIT')"> You can edit</sec:access></p>
                <p><sec:access expression="hasRole('ROLE_READ')"> You can read</sec:access></p>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <div class="panel panel-warning">
            <div class="panel-heading">
                  <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
            </div>
            <div class="panel-body">
                <p><g:message code="default.right.welcome.not.loggedin"/></p>
                <g:link controller="login"><g:message code="default.user.login"/></g:link>
                <br/>
        </sec:ifNotLoggedIn>
    <g:if test="${controllerName!=null}">
                 <g:if test="${cos.templateExists(loc: 'Right')}">
                    <g:render template="${controllerName}Right"/>
                </g:if>
        </g:if>
            </div> <!-- panel-body -->
        </div> <!-- panel -->

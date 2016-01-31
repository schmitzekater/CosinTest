    <div class="nav" role="navigation">
        <ul class="list-group">
            <li class="list-group-item active"><g:message code="default.left.sidebar"/></li>
            <g:if test="${controllerName && !controllerName.equalsIgnoreCase('common') && !controllerName.equalsIgnoreCase('login')}">
            <sec:ifLoggedIn>
                <li class="list-group-item"><g:link class="list" action="list"><g:message code="${controllerName}.label"/> <g:message code="nav.list.label"/></g:link></li>
                <sec:ifAllGranted roles="ROLE_CREATE">
                    <li class="list-group-item"><g:link class="create" action="create"><g:message code="nav.new.label"/> <g:message code="${controllerName}.label"/></g:link></li>
                </sec:ifAllGranted>
                     <g:if test="${cos.templateExists(loc: 'Left')}">
                <g:render template="${controllerName}Left"/>
                 </g:if>
             </sec:ifLoggedIn>
            </g:if>
            <li class="list-group-item">
                <a class="home" href="/">
                    <span class="glyphicon glyphicon-home" aria-hidden="true">&nbsp</span><g:message
                        code="default.home.label"/>
                </a>
            </li>
            <sec:ifNotLoggedIn>
                <li class="list-group-item">
                    <a class="home" href="/">
                        <span class="glyphicon glyphicon-home" aria-hidden="true">&nbsp</span><g:message
                            code="default.home.label"/>
                    </a>
                </li>
            </sec:ifNotLoggedIn>
        </ul>
    </div>


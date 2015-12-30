
    <div class="nav" role="navigation">
        <ul class="list-group">
            <li class="list-group-item active"><g:message code="default.left.sidebar"/></li>
            <li class="list-group-item"><g:link class="list" action="list"><g:message code="default.list.label"
                                                                                      args="[entityName]"/></g:link></li>
            <li class="list-group-item"><g:link class="create" action="create"><g:message code="default.new.label"
                                                                                          args="[entityName]"/></g:link></li>
            <g:if test="${cos.templateExists(loc: 'Left')}">
                <g:render template="${controllerName}Left"/>

            </g:if>

            <li class="list-group-item">
                <a class="home" href="/">
                    <g:message code="default.home.label"/>
                </a>
            </li>
        </ul>
    </div>

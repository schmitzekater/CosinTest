<div class="col-md-2">
    <div class="nav" role="navigation">
        <ul class="list-group">
            <li class="list-group-item"><g:link class="list" action="list"><g:message code="default.list.label"
                                                                                      args="[entityName]"/></g:link></li>
            <li class="list-group-item"><g:link class="create" action="create"><g:message code="default.new.label"
                                                                                          args="[entityName]"/></g:link></li>
            <li class="list-group-item">Porta ac consectetur ac</li>
            <li class="list-group-item">
                <a class="home" href="\${createLink(uri: '/')}">
                    <g:message code="default.home.label"/>
                </a>
            </li>
            <g:render template="${controllerName}Left"/>
        </ul>
    </div>
</div>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="${controllerName == null ? 'active ' : ''}navbar-brand " href="/">COSIN</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav">
                <!--
                Inspiration by Dan Vega
                http://therealdanvega.com/blog/2014/03/30/grails-views-controller-and-action-name
                -->
               <!-- <li class="${controllerName == null ? 'active' : ''}">
                    <a href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
                </li> -->
                <li class="${controllerName == 'user' ? 'active' : ''}">
                    <a href="${createLink(uri: '/user/list')}"><g:message code="user.label"/></a>
                </li>
                <li class="${controllerName == 'person' ? 'active' : ''}">
                    <a href="${createLink(uri: '/person/list')}"><g:message code="person.label"/></a>
                </li>
                <li class="${controllerName == 'system' ? 'active' : ''}">
                    <a href="${createLink(uri: '/system/list')}"><g:message code="system.label"/></a>
                </li>
                <li class="${controllerName == 'department' ? 'active' : ''}">
                    <a href="${createLink(uri: '/department/list')}"><g:message code="department.label"/></a>
                </li>
                <li class="${controllerName == 'unit' ? 'active' : ''}">
                    <a href="${createLink(uri: '/unit/list')}"><g:message code="unit.label"/></a>
                </li>
                <li class="${controllerName == 'module' ? 'active' : ''}">
                    <a href="${createLink(uri: '/module/list')}"><g:message code="module.label"/></a>
                </li>
                <li class="${controllerName == 'software' ? 'active' : ''}">
                    <a href="${createLink(uri: '/software/list')}"><g:message code="software.label"/></a>
                </li>
                <li class="${controllerName == 'computer' ? 'active' : ''}">
                    <a href="${createLink(uri: '/computer/list')}"><g:message code="computer.label"/></a>
                </li>
                <li class="${controllerName == 'config' ? 'active' : ''}">
                    <a href="${createLink(uri: '/config')}"><g:message code="default.config.label"/></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
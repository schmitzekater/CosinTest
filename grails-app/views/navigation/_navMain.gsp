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
            <a class="navbar-brand" href="/">COSIN</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav">
                <!--
                Inspiration by Dan Vega
                http://therealdanvega.com/blog/2014/03/30/grails-views-controller-and-action-name
                -->
                <li class="${controllerName == null ? 'active' : ''}">
                    <a href="${createLink(uri: '/')}">Home</a>
                </li>
                <li class="${controllerName == 'user' ? 'active' : ''}">
                    <a href="${createLink(uri: '/user')}">User</a>
                </li>
                <li class="${controllerName == 'person' ? 'active' : ''}">
                    <a href="${createLink(uri: '/person')}">Person</a>
                </li>
                <li class="${controllerName == 'System' ? 'active' : ''}">
                    <a href="${createLink(uri: '/system')}">Systems</a>
                </li>
                <li class="${controllerName == 'unit' ? 'active' : ''}">
                    <a href="${createLink(uri: '/unit')}">Units</a>
                </li>
                <li class="${controllerName == 'Module' ? 'active' : ''}">
                    <a href="${createLink(uri: '/module')}">Modules</a>
                </li>
                <li class="${controllerName == 'Software' ? 'active' : ''}">
                    <a href="${createLink(uri: '/software')}">Software</a>
                </li>
                <g:if test="">
                    <li>
                        <button type="button" class="btn btn-default navbar-btn">Sign in</button>
                    </li>
                </g:if>
                <g:else>
                    <p class="navbar-text">Logged in as: User</p>
                </g:else>
            </ul>
        </div>
    </div>
</nav>
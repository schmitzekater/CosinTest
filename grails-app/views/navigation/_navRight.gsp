
<sec:ifLoggedIn>
    <div class="panel panel-success">
        <div class="panel-heading">
              <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
        </div>
        <ul class="list-group">
            <li class="list-group-item">
                <g:message code="default.right.welcome.loggedin"/>
                <sec:username/>
            </li>
            <li class="list-group-item">
                <g:link controller="logout">
                    <span class="glyphicon glyphicon-off" aria-hidden="true">&nbsp</span>
                    <g:message code="default.user.logout"/></g:link>
            </li>
        <li class="list-group-item">
            <g:link controller="user" action="passwordExpired">
                <span class="glyphicon glyphicon-eye-open" aria-hidden="true">&nbsp</span>
                <g:message code="edit.password.label"/>
            </g:link>
        </li>
</sec:ifLoggedIn>
<sec:ifNotLoggedIn>
    <div class="panel panel-warning">
        <div class="panel-heading">
              <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
        </div>
        <ul class="list-group">
            <li class="list-group-item">
                <g:message code="default.right.welcome.not.loggedin"/>
            </li>
            <li class="list-group-item">
                <g:link controller="login">
                    <g:message code="default.user.login"/>
                </g:link>
            </li>
</sec:ifNotLoggedIn>
    <li class="list-group-item">
        <g:message code="language.label"/>
        <ul class="pagination pagination-sm">
            <li>
                <g:link controller="config" action="setLanguage"
                        params="[lang: 'de', targetUri: (request.forwardURI - request.contextPath)]">
                    <g:img dir="images" file="de.png"/>
                </g:link>
            </li>
            <li>
                <g:link controller="config" action="setLanguage"
                        params="[lang: 'en', targetUri: (request.forwardURI - request.contextPath)]">
                    <g:img dir="images" file="gb.png"/>
                </g:link>
            </li>
            <li>
                <g:link controller="config" action="setLanguage"
                        params="[lang: 'fr', targetUri: (request.forwardURI - request.contextPath)]">
                    <g:img dir="images" file="fr.png"/>
                </g:link>
            </li>
        </ul>
    </li>
</ul>
</div> <!-- panel -->

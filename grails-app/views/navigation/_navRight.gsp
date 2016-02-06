<sec:ifLoggedIn>
    <div class="panel panel-success">
        <div class="panel-heading">
              <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
        </div>
        <div class="panel-body">
            <p><g:message code="default.right.welcome.loggedin"/> <sec:username/></p>
    <p><g:link controller="logout"><span class="glyphicon glyphicon-off" aria-hidden="true">&nbsp</span><g:message
            code="default.user.logout"/></g:link></p>

    <p><g:link controller="user" action="editPassword"><g:message code="edit.password.label"/></g:link></p>

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

<div class="btn-group">
    <button type="button" class="btn btn-default"><g:message code="language.label"/></button>
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
        <span class="caret"></span>
        <span class="sr-only"><g:message code="language.toggle.dropdown"/></span>
    </button>
    <ul class="dropdown-menu">
        <li>
            <g:link controller="config" action="setLanguage"
                    params="[lang: 'de', targetUri: (request.forwardURI - request.contextPath)]">
                <g:img dir="images" file="de.png"/> <g:message code="language.german.label"/>
            </g:link>
        </li>
        <li>
            <g:link controller="config" action="setLanguage"
                    params="[lang: 'en', targetUri: (request.forwardURI - request.contextPath)]">
                <g:img dir="images" file="gb.png"/> <g:message code="language.english.label"/>
            </g:link>
        </li>
        <li>
            <g:link controller="config" action="setLanguage"
                    params="[lang: 'fr', targetUri: (request.forwardURI - request.contextPath)]">
                <g:img dir="images" file="fr.png"/> <g:message code="language.french.label"/>
            </g:link>
        </li>
    </ul>
</div>
</div> <!-- panel-body -->
</div> <!-- panel -->

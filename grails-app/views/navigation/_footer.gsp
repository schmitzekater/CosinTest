<div class="footer">
    <div class="container">
        <ul class="nav nav-tabs nav-justified">
            <li class="${controllerName == null ? 'active' : ''}">
                <a href="${createLink(uri: '/')}">Home</a>
            </li>
            <li class="${controllerName == 'imprint' ? 'active' : ''}">
                <%=link(uri: '/common/imprint') { 'Imprint' }%>
            </li>
            <li class="${controllerName == 'disclaimer' ? 'active' : ''}">
                <a href="${createLink(uri: '/disclaimer')}">Disclaimer</a>
            </li>
            <li role="presentation" class="disabled">
                <a href="#">App version: <g:meta name="info.app.version"/></a>
            </li>
            <li role="presentation" class="disabled">
                <a href="#">Powered by Grails <g:meta name="info.app.grailsVersion"/></a>
            </li>
        </ul>
    </div>
</div>
%{--
<div class="footer" role="contentinfo">
    <div class="well">
        <div class="row">
            <div class="col-md-2">

            </div>

            <div class="col-md-1">
                <g:link controller="user" action="list">User List</g:link>
            </div>

            <div class="col-md-1">
                <g:link controller="person" action="list">Person List</g:link>
            </div>

            <div class="col-md-1">
                Link 3
            </div>

            <div class="col-md-1">
                Link 4
            </div>

            <div class="col-md-4" align="right">
                App version: <g:meta name="info.app.version"/> Powered by Grails <g:meta
                    name="info.app.grailsVersion"/></>
        </div>

        <div class="col-md-2">
        </div>
    </div>
</div>
--}%

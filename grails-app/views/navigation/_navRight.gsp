<%@ page import="CosinTagLib" %>

    <g:if test="${session.User}">
        <div class="panel panel-success">
            <div class="panel-heading">
                  <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
            </div>
            <div class="panel-body">
                <p><g:message code="default.right.welcome.loggedin" args="['Username']" /></p>
                <p><g:link controller="user" action="list"><g:message code="default.user.logout"/></g:link></p>
                <!-- TODO
                    Hier noch mehr Zeug hin für eingelogte user
                    Beispiel: Change PW, status , Rolle etc.
                    -->
    </g:if>
    <g:else>
        <div class="panel panel-warning">
            <div class="panel-heading">
                  <h3 class="panel-title"><g:message code="default.right.sidebar"/></h3>
            </div>
            <div class="panel-body">
                <p><g:message code="default.right.welcome.not.loggedin"/></p>
                <g:link controller="user" action="list"><g:message code="default.user.login"/></g:link>
                <br/>
    </g:else>
    <g:if test="${controllerName!=null}">
                 <g:if test="${cos.templateExists(loc: 'Right')}">
                    <g:render template="${controllerName}Right"/>
                </g:if>
        </g:if>
            </div> <!-- panel-body -->
        </div> <!-- panel -->

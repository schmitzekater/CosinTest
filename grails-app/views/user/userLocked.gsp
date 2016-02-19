<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 19.02.2016
  Time: 08:48
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main"/>
</head>

<body>
    <div id='error' class="col-xs-6 col-xs-offset-2 col-md-6 col-md-offset-2 col-lg-6 col-lg-offset-2">
          <div class='panel panel-danger'>
             <div class='panel panel-heading'>
               <h2 class="panel-title"><g:message code="error.user.login"/></h2>
            </div>
            <div class="panel-body">
                <g:if test="${userStatus == 'locked'}">
                    <g:message code="user.message.account.locked" args="[username]"/>
                </g:if>
                <g:if test="${userStatus == 'disabled' }">
                    <g:message code="user.message.account.disabled" args="[username]"/>
                </g:if>
                <g:if test="${userStatus == 'expired'}">
                    <g:message code="user.message.account.expired" args="[username]"/>
                </g:if>
            </div>
            <div class="panel-footer" align="center">
                <g:link controller="login" action="auth">
                    <input class="btn btn-primary btn-md" type="submit"
                           value="${message(code: 'button.login.label')}"/>
                </g:link>
            </div>
            </div>
     </div>
</body>
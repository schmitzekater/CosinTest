<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 19.02.2016
  Time: 15:31
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
    <div class="container col-md-6 col-md-offset-1 col-lg-6 col-lg-offset-1 text-center">
        <div class="alert alert-danger">
            <h3><span class="glyphicon glyphicon-eye-close"></span> <g:message code="error.access.denied"/></h3>
        </div>
        <div>
            <div class="btn-group" role="group" aria-label="...">
                <a><input class="btn btn-default" type="submit" onclick="window.history.back()" value="${message(code: 'default.back.button', default: 'Back')}"/></a>
                <g:link controller="logout">
                    <input class="btn btn-default" type="submit" value="${message(code: 'button.logout.label')}"/>
                </g:link>
                <g:link uri="/">
                    <input class="btn btn-default" type="submit" value="${message(code: 'default.home.label')}"/>
                </g:link>
            </div>
        </div>
    </div>
</body>
</html>
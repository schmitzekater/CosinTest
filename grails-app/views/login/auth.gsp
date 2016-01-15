<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 13.01.2016
  Time: 13:41
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main"/>
</head>

<body role="document">
<div id='login' class="col-xs-6 col-xs-offset-2 col-md-6 col-md-offset-2 col-lg-6 col-lg-offset-2">
      <div class='panel panel-primary'>

      <div class='panel panel-heading'><g:message code='login.header'/></div>
     
    <table class="table table-hover">
        <form action="${postUrl ? postUrl : '/login/authenticate'}" method="POST" id="loginForm" class="cssform"
              autocomplete="off">
            <tr>
                <td><label for='username'><g:message code='user.username.label'/></label></td>
                <td><input type="text" class="text_" name="${username ? username : 'username'}" id="username"
                           value="${username ? username : ''}"/></td>
            </tr>
            <tr>
                <td><label for='password'><g:message code='user.password.label'/></label></td>
                <td><input type="password" class="text_" name="${passwordParameter ?: 'password'}" id="password"/></td>
            </tr>
            <tr>
                <td><label for="remember_me"><g:message code='login.remember.me.label'/></label></td>
                <td><input type="checkbox" class="chk" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me"
                           <g:if test="${hasCookie}">checked='checked'</g:if>/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input class="btn btn-primary btn-lg" type="submit"
                                                      value="${message(code: 'button.login.label')}"/></td>
            </tr>
        </form>
    </table>
     </div>
</div>
<script>
    (function () {
        document.forms['loginForm'].elements['${'username'}'].focus();
    })();
</script>
</body>
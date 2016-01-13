<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 13.01.2016
  Time: 11:53
  Taken from https://grails-plugins.github.io/grails-spring-security-core/v3/spring-security-core-3.0.3.pdf
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main"/>
</head>

<body role="document">
<div id='login' class="col-xs-6 col-xs-offset-2 col-md-6 col-md-offset-2 col-lg-6 col-lg-offset-2">
      <div class='panel panel-info'>

      <div class='panel panel-heading'>Please update your password..</div>
     
    <table class="table">
        <g:form action='updatePassword' id='passwordResetForm' class='cssform'
                autocomplete='off'>
            <tr>
                <td><label for='username'><g:message code='user.username.label'/></label></td>
                <td><span class='text_'>${username}</span></td>
            </tr>
            <tr>
                <td><label for='password'><g:message code='user.password.label'/></label></td>
                <td><g:passwordField name='password' class='text_'/></td>
            </tr>
            <tr>
                <td><label for='password'><g:message code='user.new.password.label'/></label></td>
                <td><g:passwordField name='password_new' class='text_'/></td>
            </tr>
            <tr>
                <td><label for='password'><g:message code='user.new.password.repeat.label'/></label></td>
                <td><g:passwordField name='password_new_2' class='text_'/></td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn btn-info" type='submit' value='Reset'/></td>
            </tr>
        </g:form>
    </table>

     
     </div>
</div>
</body>
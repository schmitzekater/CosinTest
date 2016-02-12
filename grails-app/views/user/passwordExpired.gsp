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
        <g:form action='updatePassword' id='passwordResetForm' class='cssform'
                autocomplete='off'>
            <table class="table">
                <tr>
                    <td class="control-group"><g:message code='user.username.label'/></td>
                <td><span class='text_'>${username}</span></td>
            </tr>
            <tr>
                <td class="control-group"><label for='password'><g:message code='user.password.label'/></label></td>
                <td class="control">
                    <g:passwordField name='password' class='text_'/>
                    <g:hasErrors bean="user" field="password"><span class="help-inline"><g:eachError><g:message
                            error="${it}"/><br></g:eachError></span></g:hasErrors>
                </td>
            </tr>
            <tr>
                <td class="control-group ${invalid ? 'error' : ''}">
                    <label for='password'><g:message code='user.new.password.label'/></label>
                </td>
                <td class="control">
                    <g:passwordField name='password_new' class='text_'/>
                    <g:hasErrors><span class="help-inline">${errors.join('<br>')}</span></g:hasErrors>
                </td>
            </tr>
            <tr>
                <td><label for='password'><g:message code='user.new.password.repeat.label'/></label></td>
                <td>
                    <g:passwordField name='password_new_2' class='text_'/>
                    <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn btn-info" type='submit' value='Reset'/></td>
            </tr>
            </table>
        </g:form>
     </div>
</div>
</body>
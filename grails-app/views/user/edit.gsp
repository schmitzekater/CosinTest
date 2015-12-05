<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 24.10.2015
  Time: 19:32
--%>

<%@ page import="de.schmitzekater.*" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body role="document">
    <!-- Main Block start -->
        <div id="edit-User" class="col-md-6" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]"/></h1>

        <!-- main content for page -->
            <g:form controller="User" action="update" method="PUT">
                <g:hiddenField name="version" value="${user.version}"/>
                <g:hiddenField name="id" value="${user.id}"/>
                <fieldset class="form">
                    <f:with bean="user">
                        <f:field property="userId"/>
                        <f:field property="password"/>
                        <f:field property="signature"/>
                        <f:field property="person" wrapper="/user/detail/display"/>
                        %{--Schrecklicher Hack, aber er funktioniert. Quelle: http://stackoverflow.com/questions/30623429/grails-how-to-use-exists-notexists-within-createcriteria --}%
              %{--          <div class="row-fluid">
                            <div class="col-xs-4">
                                <h4>
                                    <div class="control-group}">
                                        <label class="label label-default" for="Person"><g:message code="user.label"/> </label>
                                    </div>
                                </h4>
                            </div>
                        <div class="col-xs-8">
                            <h4>
                                <div class="controls">
                                    <g:select name="user" from="${Person.createCriteria().list(){sqlRestriction('''
                                        not exists (select 1 from Person p inner join User u on p.id = u.person_id where u.person_id = this_.id) ''')}}"
                                      optionValue="lastName" noSelection="${['null':'<No Person...>']}"></g:select>
                                </div>
                            </h4>--}%
                        </div>
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" action="update" type="submit"
                           value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                </fieldset>
            </g:form>
            <g:render template="userList" model="[users: User.getAll(), numUser: User.count]"/>
        </div>                                                                          <!-- Main Block end -->

</body>
</html>

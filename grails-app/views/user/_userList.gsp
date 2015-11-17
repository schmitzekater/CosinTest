<%@ page import="de.schmitzekater.User" %>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td><td>UserId</td><td>Password</td><td>PersonId</td>
    </tr>
    </thead>
    <tbody>
    <g:each var="user" in="${users}">
        <tr>
            <td><g:link action="detail" id="${user.id}">${user.id}</g:link></td>
            <td>${user.userId}</td>
            <td>${user.password}</td>
            <td>
                <g:if test="${user.person != null}">
                    <g:link controller="Person" action="details" id="${user.personId}">${user.person.lastName}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
            <td>
                %{--  <g:link controller="User" action="edit" id="${user.id}"><g:message code="default.edit.label"
                                                                                     args="[entityName]"/></g:link>
                  <br />--}%
                <div class="btn-group-xs">
                    <g:form controller="user" id="${user.id}">
                        <g:actionSubmit action="edit" class="btn btn-primary"
                                        value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
                        <g:actionSubmit action="detail" class="btn btn-info" value="Info"/>
                    </g:form>
                </div>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<%@ page import="de.schmitzekater.User" %>
<span class="label label-danger">Liste der Personen</span>

<p>Gefunden wurden ${numUser} User.</p>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td><td>UserId</td><td>Password</td><td>PersonId</td>
    </tr>
    </thead>
    <tbody>
    <g:each var="user" in="${users}">
        <tr>
            <td><g:link action="show" id="${user.id}">${user.id}</g:link></td>
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
                <g:link controller="User" action="edit" id="${user.id}"><g:message code="default.edit.label"/></g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
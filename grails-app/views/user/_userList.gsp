<%@ page import="de.schmitzekater.User" %>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td><td>UserId</td><td>Password</td><td>PersonId</td>
    </tr>
    </thead>
    <tbody>
    <g:each var="user" in="${model}">
        <tr>
            <td><g:link action="detail" id="${user.id}">${user.id}</g:link></td>
            <td>${user.userId}</td>
            <td>${user.password}</td>
            <td>
                <g:if test="${user.person != null}">
                    <g:link controller="Person" action="detail" id="${user.personId}">${user.person.lastName}, ${user.person.firstName}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
            <g:render template="/layouts/editInfoButtons" model="[model: user]" />
        </tr>
    </g:each>
    </tbody>
</table>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td>
        <td><g:message code="person.lastName.label"/></td>
        <td><g:message code="person.firstName.label"/> </td>
        <td><g:message code="person.email.label"/> </td>
        <td>UserId</td>
    </tr>
    </thead>
    <tbody>
    <g:each var="person" in="${model}">
        <tr>
            <td><g:link action="detail" id="${person.id}">${person.id}</g:link></td>
            <td>${person.lastName}</td>
            <td>${person.firstName}</td>
            <td>${person.email}</td>
            <td>
                <g:if test="${person.user != null}">
                    <g:link controller="User" action="detail" id="${person.userId}">${person.user.userId}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
            <g:render template="/layouts/editInfoButtons" model="[model: person]" />
        </tr>
    </g:each>
    </tbody>
</table>
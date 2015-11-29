<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td><td>Nachname</td><td>Vorname</td><td>UserId</td>
    </tr>
    </thead>
    <tbody>
    <g:each var="person" in="${model}">
        <tr>
            <td><g:link action="details" id="${person.id}">${person.id}</g:link></td>
            <td>${person.lastName}</td>
            <td>${person.firstName}</td>
            <td>
                <g:if test="${person.user != null}">
                    <g:link controller="User" action="show" id="${person.userId}">${person.user.userId}</g:link>
                </g:if>
                <g:else>
                    --
                </g:else>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
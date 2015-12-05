<table class="table table-striped">
    <thead>
    <tr>
        <td><g:message code="person.lastName.label"/></td>
        <td><g:message code="person.firstName.label"/> </td>
        <td><g:message code="person.email.label"/> </td>
        <td><g:message code="user.userId.label"/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="person" in="${model}">
        <tr>
            <f:with bean="${person}">
                <f:display property="lastName"/>
                <f:display property="firstName"/>
                <f:display property="email"/>
                <f:display property="user"/>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: person]" />
        </tr>
    </g:each>
    </tbody>
</table>
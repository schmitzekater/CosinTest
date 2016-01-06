<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="lastName" title="${message(code: 'person.lastName.label', default: 'Last Name')}"/>
        <g:sortableColumn property="firstName" title="${message(code: 'person.firstName.label', default: 'First Name')}"/>
        <g:sortableColumn property="email" title="${message(code: 'person.email.label', default: 'Email')}"/>
        <g:sortableColumn property="department" title="${message(code: 'department.departmentName.label', default: 'Email')}"/>
        <g:sortableColumn property="user" title="${message(code: 'user.userId.label', default: 'User ID')}"/>
    </tr>
    </thead>
    <tbody>
    <g:each var="person" in="${model}">
        <tr>
            <f:with bean="${person}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="lastName" wrapper="list"/>
                <f:display property="firstName" wrapper="list"/>
                <f:display property="email" wrapper="list"/>
                <f:display property="department" wrapper="list/link/department"/>
                <f:display property="user" wrapper="list/link/user"/>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: person]" />
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
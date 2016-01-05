<%@ page import="de.schmitzekater.User" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="userId" title="${message(code: 'user.userId.label', default: 'User ID')}"/>
        <g:sortableColumn property="password" title="${message(code:'user.password.label', default: 'Password')}"/>
        <g:sortableColumn property="signature" title="${message(code: 'user.signature.label', default: 'Signature')}"/>
        <g:sortableColumn property="person" title="${message(code:'person.label', default: 'Person')}"/>
    </tr>
    </thead>
    <tbody>
    <g:each var="user" in="${model}">
        <tr>
            <f:with bean="${user}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="userId" wrapper="list"/>
                <f:display property="password" wrapper="list/secret"/>
                <f:display property="signature" wrapper="list/secret"/>
                <f:display property="person" wrapper="list/link"/>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: user]" />
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
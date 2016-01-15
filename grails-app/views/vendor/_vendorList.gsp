<%@ page import="de.schmitzekater.Vendor" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="name" title="${message(code: 'vendor.name.label', default: 'Name')}"/>
        <g:sortableColumn property="url" title="${message(code:'vendor.url.label', default: 'URL')}"/>
        <g:sortableColumn property="address" title="${message(code: 'vendor.address.label', default: 'Address')}"/>

        <th><a href="#"><g:message code='action.label'/></a></th>
    </tr>
    </thead>
    <tbody>
    <g:each var="vendor" in="${model}">
        <tr>
            <f:with bean="${vendor}" wrapper="list">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="name" wrapper="list"/>
                <f:display property="url" wrapper="list/link/externally"/>
                <f:display property="address" wrapper="list/address"/>
            </f:with>

            <g:render template="/layouts/editInfoButtons" model="[model: vendor]" />

        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
<%@ page import="de.schmitzekater.Unit" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="unitName" title="${message(code: 'unit.unitName.label', default: 'Name')}"/>
        <g:sortableColumn property="system" title="${message(code:'system.label', default: 'System')}"/>
        <th><a href="#"><g:message code="module.count.label"/></a></th>
        <g:if test="${controllerName.compareToIgnoreCase('Unit')==0}">
            <th><a href="#"><g:message code='action.label'/></a></th>
        </g:if>
    </tr>
    </thead>
    <tbody>
    <g:each var="unit" in="${model}">
        <tr>
            <f:with bean="${unit}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="unitName" wrapper="list"/>
                <f:display property="system" wrapper="list/link"/>
                <td>${unit.modules.size()}</td>
            </f:with>
            <g:render template="/layouts/editInfoButtons" model="[model: unit]" />
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
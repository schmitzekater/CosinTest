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
                <f:display property="system" wrapper="list/link/system"/>
                <td>${unit.modules.size()}</td>
            </f:with>
            %{--Only render the Buttons if on Unit-Controller--}%
            <g:if test="${controllerName.compareToIgnoreCase('Unit')==0}">
                <g:render template="/layouts/editInfoButtons" model="[model: unit]" />
            </g:if>
            %{-- Render the remove button if on System controller --}%
            <g:if test="${controllerName.compareToIgnoreCase('System')==0}">
                <td>
                <g:link action="detail" id="${unit.id}" controller="unit">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
                            code="info.unit"/>'></span>
                </g:link>
                <sec:link controller="system" action="removeUnit" id="${params.id}" params="[unit: unit.id]"
                          expression="hasAnyRole('ROLE_EDIT,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-minus-sign" aria-hidden="true" style="color:red" title='<g:message
                        code="system.remove.unit"/>'>&nbsp;</span>
                </sec:link>
                </td>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
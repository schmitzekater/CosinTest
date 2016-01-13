<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="moduleType" title="${message(code: 'ModuleType.label', default: 'Module Type')}" />
        <g:sortableColumn property="moduleSerial" title="${message(code: 'module.moduleSerial.label', default: 'Serial')}"/>
        <g:sortableColumn property="moduleName" title="${message(code: 'module.moduleName.label', default: 'Name')}" />
        <g:sortableColumn property="moduleVendor" title="${message(code: 'vendor.label', default: 'Vendor')}"/>
        <g:sortableColumn property="unit" title="${message(code: 'unit.label', default: 'Unit')}" />
        <g:if test="${controllerName.compareToIgnoreCase('Module')==0}">
            <th><a href="#"><g:message code='action.label'/></a></th>
        </g:if>
    </tr>
    </thead>
    <tbody>
    <g:each var="module" in="${model}">
        <tr>
            <f:with bean="${module}">
            <f:display property="id" wrapper="list/link"/>
            <f:display property='moduleType' wrapper="list"/>
            <f:display property='moduleSerial' wrapper="list"/>
            <f:display property='moduleName' wrapper="list"/>
            <f:display property='moduleVendor' wrapper="list/link/vendor"/>
            <f:display property='unit' wrapper="list/link/unit"/>
            </f:with>
            %{--Only render the Buttons if on Module-Controller--}%
            <g:if test="${controllerName.compareToIgnoreCase('Module')==0}">
                <g:render template="/layouts/editInfoButtons" model="[model: module]"/>
            </g:if>
            %{-- Render the remove button if on Unit controller --}%
            <g:if test="${controllerName.compareToIgnoreCase('Unit')==0}">
                <sec:ifAnyGranted roles="'ROLE_EDIT', 'ROLE_DELETE'">
                    <td class="btn-group-xs">
                        <g:form controller = "unit" id="${params.id}" params="[module: module.id]">
                            <g:actionSubmit action="removeModule" class="btn btn-danger"
                                            value="${message(code: 'default.button.remove.miniLabel', default: 'Remove')}"/>
                        </g:form>
                    </td>
                </sec:ifAnyGranted>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>

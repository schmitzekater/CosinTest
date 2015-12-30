<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="moduleType" title="${message(code: 'ModuleType.label', default: 'Module Type')}" />
        <g:sortableColumn property="moduleSerial" title="${message(code: 'module.moduleSerial.label', default: 'Serial')}"/>
        <g:sortableColumn property="moduleName" title="${message(code: 'module.moduleName.label', default: 'Name')}" />
        <g:sortableColumn property="moduleVendor" title="${message(code: 'module.moduleVendor.label', default: 'Vendor')}"/>
        <g:sortableColumn property="unit" title="${message(code: 'unit.label', default: 'Unit')}" />
    </tr>
    </thead>
    <tbody>
    <g:each var="module" in="${model}">
        <tr>
            <f:with bean="${module}">
            <td><g:link action="show" id="${module.id}"><f:display property="id"/></g:link></td>
            <td><f:display property='moduleType'/></td>
            <td><f:display property='moduleSerial'/></td>
            <td><f:display property='moduleName'/></td>
            <td><f:display property='moduleVendor'/></td>
            <td><f:display property='unit'/></td>
            <g:render template="/layouts/editInfoButtons" model="[model: module]"/>
            </f:with>
        </tr>
    </g:each>
    </tbody>
</table>

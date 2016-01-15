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
            <th>
                <a href="#">${message(code: 'module.calibrationInterval.label', default: 'Calibration Interval')}</a>
            </th>
            <th>
                <a href="#">${message(code: 'module.nextCalibration.label', default: 'Next Calibration')}</a>
            </th>
        </g:if>
        <g:if test="${controllerName.compareToIgnoreCase('Module') == 0}">
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
                <g:if test="${controllerName.compareToIgnoreCase('Module') == 0}">
                    <f:display property="needsCalibration" wrapper="list/date/calibInterval/"/>
                    <f:display property="nextCalibration" wrapper="list/date/colored" widget="detail/date/colored"/>
                </g:if>
            </f:with>
            %{--Only render the Buttons if on Module-Controller--}%
            <g:if test="${controllerName.compareToIgnoreCase('Module')==0}">
                <g:render template="/layouts/editInfoButtons" model="[model: module]"/>
            </g:if>
            %{-- Render the remove button if on Unit controller --}%
            <g:if test="${controllerName.compareToIgnoreCase('Unit')==0}">
                <td><g:link action="detail" id="${module.id}" controller="module">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
                            code="info.module"/>'>
                </g:link>
                    <sec:link controller="unit" id="${params.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_DELETE')"
                              params="[module: module.id]" action="removeModule">
                    <span class="glyphicon glyphicon-remove" style="color:red" aria-hidden="true"
                          title='<g:message code="unit.remove.module"/>'></span>
                    </sec:link></td>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>

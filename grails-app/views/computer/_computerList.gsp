<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="computerName" title="${message(code: 'computer.computerName.label', default: 'Name')}"/>
        <g:sortableColumn property="computerVendor" title="${message(code: 'computer.computerVendor.label', default: 'Vendor')}"/>
        <th><a><g:message code="software.label"/></a></th>
        <g:if test="${controllerName.compareToIgnoreCase('Computer')==0}">
            <th>
                <a href="#">${message(code: 'computer.computerRole.label', default: 'Role')} (${message(code: 'system.name.label', default: 'System')})</a>
            </th>
        </g:if>
        <g:else>
            <th>
                <a href="#">${message(code: 'computer.computerRole.label', default: 'Role')}</a>
            </th>
        </g:else>
        <th/>
    </tr>
    </thead>
    <tbody>
    <g:each var="computer" in="${model}">
        <tr>
            <f:with bean="${computer}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="computerName"  wrapper="list"/>
                <f:display property="computerVendor" wrapper="list/link/vendor"/>
                <td>${computer.installedSoftware.size()}</td>
                <g:if test="${controllerName.compareToIgnoreCase("System")==0}">
                    %{-- Only render the computers and roles, that are used by this system. --}%
                    <g:render template="/computer/computerRolesList" model="${roles=computer.getSystemRolesBySystem(System.get(params.id))}"/>
                </g:if>
               <g:else>
                   %{-- Render all computers and their roles --}%
                   <g:render template="/computer/computerRolesList" model="${roles=computer.getSystemRoles()}"/>
               </g:else>
            </f:with>
            %{--Only render the Buttons if on Computer-Controller--}%
            <g:if test="${controllerName.compareToIgnoreCase('Computer')==0}">
                <g:render template="/layouts/editInfoButtons" model="[model: computer]"/>
            </g:if>
            %{-- Render the remove button if on System controller --}%
            <g:if test="${controllerName.compareToIgnoreCase('System')==0}">
                <td>
                <g:link action="detail" id="${computer.id}" controller="computer">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
                            code="info.computer"/>'></span>
                </g:link>
                <sec:link controller="system" action="removeComputer" id="${params.id}" params="[computer: computer.id]"
                          expression="hasAnyRole('ROLE_EDIT,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-minus-sign" aria-hidden="true" style="color:red" title='<g:message
                        code="system.remove.computer"/>'>&nbsp;</span>
                </sec:link>
                </td>
            </g:if>
        </tr>
    </g:each>
    </tbody>
</table>
<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default: 'ID')}"/>
        <g:sortableColumn property="computerName" title="${message(code: 'computer.computerName.label', default: 'Name')}"/>
        <g:sortableColumn property="computerVendor" title="${message(code: 'computer.computerVendor.label', default: 'Vendor')}"/>
        <g:if test="${controllerName.compareToIgnoreCase('Computer')==0}">
            <td>
                <b>${message(code: 'computer.computerRole.label', default: 'Role')} (${message(code: 'system.name.label', default: 'System')})</b>
            </td>
        </g:if>
        <g:else>
           <td>
               <b>${message(code: 'computer.computerRole.label', default: 'Role')}</b>
           </td>
        </g:else>
    </tr>
    </thead>
    <tbody>
    <g:each var="computer" in="${model}">
        <tr>
            <f:with bean="${computer}">
                <f:display property="id" wrapper="list/link"/>
                <f:display property="computerName"  wrapper="list"/>
                <f:display property="computerVendor" wrapper="list/link/vendor"/>
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
        </tr>
    </g:each>
    </tbody>
</table>
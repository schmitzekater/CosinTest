<f:with bean="computer">
    <f:display property="computerName" wrapper="detail"/>
    <f:display property="computerVendor" wrapper="detail/link/vendor"/>
    <f:display property="installedSoftware" wrapper="detail"/>
    <g:render template="/computer/computerRolesDetail" model="${computer}"/>
</f:with>
<sec:link action="edit" id="${computer.id}" class="btn btn-primary"
          expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')" controller="computer"
          title="${message(code: 'edit.computer', default: 'Edit')}">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>



<f:with bean="computer">
    <f:display property="computerName" wrapper="detail"/>
    <f:display property="computerVendor" wrapper="detail/link/vendor"/>
    <f:display property="installedSoftware" wrapper="detail/link/software"/>
    <g:render template="/computer/computerRolesDetail" model="${computer}"/>
</f:with>
<g:if test="${computer.installedSoftware.size() > 0}">
    <h3><g:message code="computer.installedSoftware.label"/></h3>
    <g:render template="/software/softwareList" model="[model: computer.installedSoftware]"/>
</g:if>
<sec:link action="edit" id="${computer.id}" class="btn btn-primary"
          expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')" controller="computer"
          title="${message(code: 'edit.computer', default: 'Edit')}">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>



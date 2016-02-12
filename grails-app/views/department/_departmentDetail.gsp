<%@ page import="de.schmitzekater.*" %>
<f:with bean="department">
    <f:display property="departmentName" wrapper="detail"/>
    <f:display property="supervisor" wrapper="detail/link/person"/>
</f:with>
<sec:link action="edit" class="btn btn-primary" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
          id="${department.id}" title="${message(code: "edit.department")}" controller="department">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>

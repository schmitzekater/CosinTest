<%@ page import="de.schmitzekater.*" %>

<table class="table table-striped">
    <tbody>
        <f:with bean="department">
            <f:display property="departmentName" wrapper="detail"/>
            <f:display property="supervisor" wrapper="detail/link/person"/>
        </f:with>
    </tbody>
</table>
<g:form controller="department" id="${department.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>

<%@ page import="de.schmitzekater.SystemRole" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.10.2015
  Time: 18:05
--%>
<table class="table table-striped">

    <tbody>
        <f:with bean="system">
            <f:display property="systemName" wrapper="detail"/>
            <f:display property="systemDepartment" wrapper="detail/link/department"/>
            <f:display property="systemOwner" wrapper="detail/link/person"/>
            <f:display property="processOwner" wrapper="detail/link/person"/>
            <f:display property="area" wrapper="detail"/>
            <f:display property="systemDataCategory" wrapper="detail"/>
        </f:with>
    </tbody>
</table>
<g:form controller="system" id="${system.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>



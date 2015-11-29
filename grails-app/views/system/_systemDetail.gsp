<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.10.2015
  Time: 18:05
--%>
-->
<table class="table table-striped">

    <tbody>
        <f:with bean="system">
            <f:display property=""/>
            <f:display property=""/>
            <f:display property=""/>
            <f:display property=""/>
        </f:with>
    </tbody>
</table>
<g:form controller="system" id="${user.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>

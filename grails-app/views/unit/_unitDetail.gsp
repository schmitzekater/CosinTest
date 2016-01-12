<%@ page import="de.schmitzekater.*" %>

<table class="table table-striped">
    <tbody>
    <f:with bean="unit">
        <f:display property="unitName" wrapper="detail"/>
        <f:display property="system" wrapper="detail/link/system"/>
    </f:with>
    </tbody>
</table>
<g:if test="${unit.modules != null}">
    <h3><g:message code="module.moduleList.label"/></h3>
    <g:render template="/module/moduleList" model="[model: unit.modules]"/>
</g:if>
<g:form controller="unit" id="${unit.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>
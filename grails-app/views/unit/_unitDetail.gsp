<%@ page import="de.schmitzekater.*" %>

<f:with bean="unit">
    <f:display property="unitName" wrapper="detail"/>
    <f:display property="system" wrapper="detail/link/system"/>
</f:with>
<g:if test="${unit.modules != null}">
    <h3><g:message code="module.moduleList.label"/></h3>
    <g:render template="/module/moduleList" model="[model: unit.modules]"/>
</g:if>
<sec:link action="edit" class="btn btn-primary" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
          id="${unit.id}" title="${message(code: "edit.unit")}" controller="unit">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>

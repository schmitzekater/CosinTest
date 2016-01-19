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
<sec:link expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')" controller="system" id="${system.id}"
          action="edit" class="btn btn-primary">
    ${message(code: 'default.button.edit.label', default: 'Edit')}
</sec:link>
<%-- Get thte units of the system --%>
<h3><g:message code="unit.list.label"/></h3>
<g:if test="${system.units.size()>0}">
    <g:render template="/unit/unitList" model="${[model: system.units]}"/>
</g:if>
<g:else>
    <g:message code="system.no.unit"/>
</g:else>
<%-- Get the software of the system --%>
<h3><g:message code="software.list.label"/></h3>
<g:if test="${system.software.size()>0}">
    <g:render template="/software/softwareList" model="[model: system.software]"/>
</g:if>
<g:else>
    <g:message code="system.no.software"/>
</g:else>
<%-- Get the computers of the system --%>
<h3><g:message code="computer.list.label"/></h3>
<g:if test="${system.computer.size()>0}">
    <g:render template="/computer/computerList" model="${[model: system.getComputer()]}"/>
</g:if>
<g:else>
    <g:message code="system.no.computer"/>
</g:else>




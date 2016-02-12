<%@ page import="de.schmitzekater.SystemRole" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.10.2015
  Time: 18:05

  Page to display the Details of a System.
  renders also
  - the list of units (/unit/_unitList.gsp)
  - list of Computer (/computer/_computerList.gsp)
   - list of Software (/software/_softwareList.gsp)
--%>
<f:with bean="system">
    <f:display property="systemName" wrapper="detail"/>
    <f:display property="systemDepartment" wrapper="detail/link/department"/>
    <f:display property="systemOwner" wrapper="detail/link/person"/>
    <f:display property="processOwner" wrapper="detail/link/person"/>
    <f:display property="area" wrapper="detail"/>
    <f:display property="systemDataCategory" wrapper="detail"/>
    <f:display property="dataFlow" wrapper="detail/link/file"/>
</f:with>

<g:if test="${!system.isActive}">
    <div class="alert alert-danger">
        <g:message code="system.retired.since"/>
        <f:display bean="${system}" property="retirementDate" wrapper="detail/date/since"/>
    </div>
</g:if>
<g:else>
    <sec:link expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')" controller="system" id="${system.id}"
              action="edit" class="btn btn-primary">
        ${message(code: 'default.button.edit.label', default: 'Edit')}
    </sec:link>
    <sec:link expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')" controller="system" id="${system.id}"
              action="retireSystem" class="btn btn-danger">
        ${message(code: 'default.button.retire.label', default: 'Retire')}
    </sec:link>
    <g:render template="/layouts/editInfoButtons" model="[model: system]"/>
</g:else>
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
<g:if test="${system.usesSoftware.size()>0}">
    <g:render template="/software/softwareList" model="[model: system.usesSoftware]"/>
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




<%--
    This template renders icons for the tabular lists.
    Depending on the type of Object different icons are shown.
    Except the info icon all icons are only displayed when a user is logged on.

    Icons:
    - Info                  (Standard for every Object, Link to detailed view of Object)
    - Edit                  (Edit an Object. Not available in AuditTrailController)
    - addQualification      (Available for Modules and Software)
    - addSoftwareToComputer (Add a software to a computer)
    - addUnitToSystem       (Add an Unit to a System)
    - editDataFlow          (Edit the dataflow File of a System)
    - createSystemReport    (Create a PDF-Report of a System)
    - addModuleToUnit       (Add a Module to an Unit)

--%>
<td>
    %{--Don't display the edit button on Audit Trail (cannot be edited)--}%
    <g:if test="${controllerName.compareToIgnoreCase("AuditLogEvent") != 0}">
        <sec:link action="edit" id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
            <span class="glyphicon glyphicon-pencil" style="color: orange" aria-hidden="true" title='<g:message
                code="edit.${controllerName}"/>'>
        </sec:link>
    </g:if>
    %{--Don't display the Detail-Link when the action is detail.--}%
    <g:if test="${actionName.compareToIgnoreCase("detail")!=0}">
        <g:link action="detail" id="${model.id}">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true" title='<g:message
                code="info.${controllerName}"/>'>
        </g:link>
    </g:if>
    %{--Render the User-Buttons when on user controller--}%
    <g:if test="${controllerName.compareToIgnoreCase("User") == 0}">
        <g:render template="/layouts/userEditButtons" model="[model: model]"/>
    </g:if>
    <g:if test="${controllerName.compareToIgnoreCase("Module") == 0 || controllerName.compareToIgnoreCase("Software") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addQualificationToObject">
            <span class="glyphicon glyphicon-wrench" aria-hidden="true" title='<g:message
                code="default.add.Qualification"/>'>
        </sec:link>
    </g:if>
    %{--Display the addSoftware icon when on Computerr--}%
    <g:if test="${controllerName.compareToIgnoreCase("Computer") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addSoftwareToComputer" >
            <span class="glyphicon glyphicon-plus-sign" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Software"/>'>
        </sec:link>
    </g:if>
    %{--Display add Unit, editDataFlow and createSystemReport icon on System controller--}%
    <g:if test="${controllerName.compareToIgnoreCase("System") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addUnitToSystem" >
            <span class="glyphicon glyphicon-tasks" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Unit"/>'>
        </sec:link>
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addComputerToSystem" >
            <span class="glyphicon glyphicon-plus-sign" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Computer"/>'>
        </sec:link>
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="editDataFlow" >
            <span class="glyphicon glyphicon-list-alt" style="color: green" aria-hidden="true" title='<g:message
                code="system.edit.dataFlow"/>'>
        </sec:link>
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="createSystemReport" >
            <span class="glyphicon glyphicon-print" style="color: blueviolet" aria-hidden="true" title='<g:message
                code="system.create.report"/>'>
        </sec:link>
    </g:if>
    %{--Display addModule icon on Unit controller--}%
    <g:if test="${controllerName.compareToIgnoreCase("Unit") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addModuleToUnit" >
            <span class="glyphicon glyphicon-hdd" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Module"/>'>
        </sec:link>
    </g:if>
</td>
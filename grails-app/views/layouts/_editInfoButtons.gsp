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
    %{--Display the add Software Button when on Computer or System Controller--}%
    <g:if test="${controllerName.compareToIgnoreCase("Computer") == 0 || controllerName.compareToIgnoreCase("System") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addSoftwareToComputer" >
            <span class="glyphicon glyphicon-plus-sign" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Software"/>'>
        </sec:link>
    </g:if>
    %{--Display add Unit and add Module button on System controller--}%
    <g:if test="${controllerName.compareToIgnoreCase("System") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addUnitToSystem" >
            <span class="glyphicon glyphicon-tasks" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Unit"/>'>
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
    %{--Display add  add Module button on Unit controller--}%
    <g:if test="${controllerName.compareToIgnoreCase("Unit") == 0}">
        <sec:link id="${model.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
                  action="addModuleToUnit" >
            <span class="glyphicon glyphicon-hdd" style="color: green" aria-hidden="true" title='<g:message
                code="default.add.Module"/>'>
        </sec:link>
    </g:if>
</td>
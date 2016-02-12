<div class="panel-body" id="moduleTypes">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="type" id="ModuleType" value="ModuleType"/>
        <g:submitToRemote value="+" url="[action: 'addModuleType']" update="moduleTypes"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()"/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif"/>
        <g:if test="${flash.error}">
            <div class="messages error-message"> <label class="label label-danger">${flash.error}</label></div>
        </g:if>
        <g:if test="${flash.message}">
            <div class="messages success-message"><label class="label label-success">${flash.message}</label></div>
        </g:if>
    </g:form>
    <ul>
        <g:each var="mt" in="${moduleTypes}">
            <li>${mt.toString()}
                <sec:link action="editModuleType" id="${mt.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-pencil" style="color: orange" aria-hidden="true" title='<g:message
                            code="edit.moduleType"/>'></span>
                </sec:link>
            </li>
        </g:each>
    </ul>
</div>
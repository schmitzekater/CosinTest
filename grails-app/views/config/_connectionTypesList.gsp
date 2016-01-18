<div class="panel-body" id="connectionTypes">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="type" id="ConnectionType" value="ConnectionType"/>
        <g:submitToRemote value="+" url="[action: 'addConnectionType']" update="connectionTypes"
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
        <g:each var="ct" in="${connectionTypes}">
            <li>${ct.toString()}
                <sec:link action="editConnectionType" id="${ct.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-pencil" style="color: orange" aria-hidden="true" title='<g:message
                        code="edit.connectionType"/>'>
                </sec:link>
            </li>
        </g:each>
    </ul>
</div>
<div class="panel-body" id="qualificationTypes" onload="fadeMessages()">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="type" id="QualificationType" value="QualificationType"/>
        <g:submitToRemote value="+" url="[action: 'addQualificationType']" update="qualificationTypes"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()" onFailure=""/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif" alt="spinner"/>
        <g:if test="${flash.error}">
            <div class="messages error-message"> <label class="label label-danger">${flash.error}</label></div>
        </g:if>
        <g:if test="${flash.message}">
            <div class="messages success-message"><label class="label label-success">${flash.message}</label></div>
        </g:if>
    </g:form>

    <ul>
        <g:each var="qt" in="${qualificationTypes}">
            <li>${qt.toString()}
                <sec:link action="editQualificationType" id="${qt.id}" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
                    <span class="glyphicon glyphicon-pencil" style="color: orange" aria-hidden="true" title='<g:message
                            code="edit.qualificationType"/>'></span>
                </sec:link>
            </li>
        </g:each>
    </ul>
</div>
<div class="panel-body" id="qualificationTypes">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="type" id="QualificationType" value="QualificationType"/>
        <g:submitToRemote value="+" url="[action: 'addQualificationType']" update="qualificationTypes"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()"/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif"/>
    </g:form>
    <ul>
        <g:each var="qt" in="${qualificationTypes}">
            <li>${qt.toString()}</li>
        </g:each>
    </ul>
</div>
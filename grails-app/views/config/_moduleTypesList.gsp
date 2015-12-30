<div class="panel-body" id="moduleTypes">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="type" id="ModuleType" value="ModuleType"/>
        <g:submitToRemote value="+" url="[action: 'addModuleType']" update="moduleTypes"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()"/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif"/>
    </g:form>
    <ul>
        <g:each var="mt" in="${moduleTypes}">
            <li>${mt.toString()}</li>
        </g:each>
    </ul>
</div>
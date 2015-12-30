<div class="panel-body" id="computerRoles">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="role" id="ComputerRole" value="Computer Role"/>
        <g:submitToRemote value="+" url="[action: 'addComputerRole']" update="computerRoles"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()"/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif"/>
    </g:form>
    <ul>
        <g:each var="cr" in="${computerRoles}">
            <li>${cr.toString()}</li>
        </g:each>
    </ul>
</div>
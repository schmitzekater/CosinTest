<div class="panel-body" id="connectionTypes">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="type" id="ConnectionType" value="ConnectionType"/>
        <g:submitToRemote value="+" url="[action: 'addConnectionType']" update="connectionTypes"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()"/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif"/>
    </g:form>
    <ul>
        <g:each var="ct" in="${connectionTypes}">
            <li>${ct.toString()}</li>
        </g:each>
    </ul>
</div>
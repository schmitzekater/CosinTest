<div class="panel-body" id="dataCategories">
    <g:form>
        <label><g:message code="default.add.short.label"/>: </label>
        <g:textField name="category" id="DataCategory" value="Data Category"/>
        <g:submitToRemote value="+" url="[action: 'addDataCategory']" update="dataCategories"
                          onLoading="showSpinner(true)" onComplete="showSpinner(false);refresh()"/>
        <g:img id="spinner" style="display: none" dir="images" file="spinner.gif"/>
    </g:form>
    <ul>
        <g:each var="dc" in="${dataCategories}">
            <li>${dc.toString()}</li>
        </g:each>
    </ul>
</div>
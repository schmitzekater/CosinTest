<g:if test="${flash.message}">
    <div class="alert alert-info" role="info">${flash.message}</div>
</g:if>
<g:if test="${flash.error}">
    <div class="alert alert-danger" role="alert" style="display: block">${flash.error}</div>
</g:if>
<g:hasErrors bean="[entityName]">
    <div class="alert alert-info" role="alert">
        <ul class="errors" role="alert">
            <g:eachError var="error">
                <li><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </div>
</g:hasErrors>
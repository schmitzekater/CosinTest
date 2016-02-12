<g:if test="${flash.message}">
    <div class="alert alert-success" id="topAlerts">${flash.message}</div>
</g:if>
<g:if test="${flash.error}">
    <div class="alert alert-danger" role="alert" style="display: block" id="topErrors">${flash.error}
        <g:hasErrors>
            <p class="error-expand"><a href="#"><b>Details:</b></a></p>

            <div class="alert alert-warning error-content" role="alert">
                <ul class="errors">
                    <g:eachError var="error">
                        <li><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </div>
        </g:hasErrors>
    </div>
</g:if>

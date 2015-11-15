<g:if test="${flash.message}">
    <div class="alert alert-info" role="info">${flash.message}</div>
</g:if>
<g:if test="${flash.error}">
    <div class="alert alert-danger" role="alert" style="display: block">${flash.error}
        <g:hasErrors>
            <p><b>Details:</b></p>

            <div class="alert alert-warning" role="alert">
                <ul class="errors" role="alert">
                    <g:eachError var="error">
                        <li><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </div>
        </g:hasErrors>
    </div>
</g:if>

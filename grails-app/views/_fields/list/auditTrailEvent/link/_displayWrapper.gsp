%{--This template allows easy access to the changed domain object.
It displays a link to the specific ID.--}%

<!-- Template: /_fields/list/auditTrailEvent/link/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link action="detail" id="${bean.persistedObjectId}" controller="${value}">
            ${value} (ID:${bean.persistedObjectId})
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
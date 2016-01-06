<!-- Template: /_fields/list/link/department/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="deparment" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
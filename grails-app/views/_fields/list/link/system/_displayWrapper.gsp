<!-- Template: /_fields/list/link/system/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="System" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
<!-- Template: /_fields/list/link/unit/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="unit" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
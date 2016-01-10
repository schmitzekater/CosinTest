<!-- Template: /_fields/list/link/person/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="person" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
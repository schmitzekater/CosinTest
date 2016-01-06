<!-- Template: /_fields/list/link/user/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="user" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
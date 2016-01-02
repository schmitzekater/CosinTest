<!-- Template: /_fields/list/link/vendor/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="Vendor" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
<!-- Template: /_fields/list/link/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link action="detail" id="${value}">
            ${value}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
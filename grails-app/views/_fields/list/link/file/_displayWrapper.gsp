<!-- Template: /_fields/list/link/file/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <a href="file://${value}" target="_blank">${value.name}</a>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
<!-- Template: /_fields/list/link/externally/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <a href="${value}" target="_blank">${value}</a>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
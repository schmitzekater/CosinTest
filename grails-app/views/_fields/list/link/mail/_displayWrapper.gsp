<!-- Template: /_fields/list/link/externally/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <a href="mailto:${value}">${value}</a>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
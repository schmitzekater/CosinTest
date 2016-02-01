<!-- Template: /_fields/list/link/file/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="common" action="downloadAttachment" id="${bean.id}">${value.name}</g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
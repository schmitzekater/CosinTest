<!-- Template: /user/list/user/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="person" id="${value.id}" action="detail">${value.getDisplayString()}</g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
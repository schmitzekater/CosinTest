<!-- Template: /person/list/user/_display.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="user" id="${value.id}" action="detail">${value.getDisplayString()}</g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
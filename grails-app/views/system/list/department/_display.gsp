<!-- Template: /system/list/department/_display.gsp -->
<td>
    <g:if test="${value}">
        <g:link controller="Department" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
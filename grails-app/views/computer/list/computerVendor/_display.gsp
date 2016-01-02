<!-- Template: /computer/list/computerVendor/_display.gsp -->
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
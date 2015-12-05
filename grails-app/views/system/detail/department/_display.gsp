<%@ page defaultCodec="html" %>
<!-- template /system/detail/department/display -->
<tr>
    <td><b>${label}</b></td>
    <td>
        <g:if test="${value}">
            <g:link controller="department" id="${value.id}" action="detail">
                ${value.getDisplayString()}
            </g:link>
        </g:if>
        <g:else>
            --
        </g:else>

    </td>
</tr>



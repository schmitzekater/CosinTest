<%@ page defaultCodec="html" %>
<!-- Template: person/detail/user/display -->
<tr>
    <td><b>${label}</b></td>
    <td>
        <g:if test="${value}">
                ${value.getDisplayString()}
        </g:if>
        <g:else>
            --
        </g:else>
    </td>
</tr>



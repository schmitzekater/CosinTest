<%@ page defaultCodec="html" %>
<!-- template /user/detail/display -->
<tr>
    <td><b>${label}</b></td>
    <td>
        <g:if test="${value}">
            ${value}
        </g:if>
        <g:else>
            --
        </g:else>

    </td>
</tr>



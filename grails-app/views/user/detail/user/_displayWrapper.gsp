<%@ page defaultCodec="html" %>
<!-- Template: user/detail/user/displayWrapper.gsp -->
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



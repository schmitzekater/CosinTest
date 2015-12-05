<%@ page defaultCodec="html;charset=UTF-8" %>
%{--<tr>
    <td><b>${label}</b></td>
    <td>--}%
<dt>${label}
    <dd>
        <g:if test="${value}">
            ${value}
        </g:if>
        <g:else>
            --
        </g:else>
</dd>
</dt>
%{--
    </td>
</tr> --}%



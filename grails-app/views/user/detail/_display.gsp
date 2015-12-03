<%@ page defaultCodec="html" %>
<tr>
    <td><b>${label}</b></td>
    <td>
        %{--Wenn die Person angezeigt wird, soll der Nach- und Vorname angezeigt werden--}%
        <g:if test="${label.equals('Person')}">
            ${user?.person?.getDisplayString()}
        </g:if>
        <g:elseif test="${value}">
            ${value}
        </g:elseif>
        <g:else>
            --
        </g:else>

    </td>
</tr>



<%@ page defaultCodec="html" %>
<tr>
    <td><b>${label}</b></td>
    <td>
        %{--Wenn die Person angezeigt wird, soll der Nach- und Vorname angezeigt werden--}%
        <g:if test="${label.equals('System Owner')}">
            <g:link controller="person" action="detail" id="${system.systemOwner.id}">
                ${system.systemOwner.getDisplayString()}
            </g:link>
        </g:if>
        <g:elseif test="${label.equals('Process Owner')}">
            <g:link controller="person" action="detail" id="${system.systemOwner.id}">
                ${system.processOwner.getDisplayString()}
            </g:link>
        </g:elseif>
        <g:elseif test="${value}">
            ${value}
        </g:elseif>
        <g:else>
            --
        </g:else>

    </td>
</tr>



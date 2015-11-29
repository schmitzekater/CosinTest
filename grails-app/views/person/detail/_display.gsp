<%@ page defaultCodec="html" %>
<tr>
    <td><b>${label}</b></td>
    <td>
        <g:if test="${value}">
            <g:if test="${label.compareToIgnoreCase('User id')==0}">
                <g:link controller="User" action="detail" id="${person.userId}">${value}</g:link>
            </g:if>
            <g:else>${value}</g:else>
        </g:if>
        <g:else>

        </g:else>
    </td>
</tr>
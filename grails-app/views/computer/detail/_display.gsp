<%@ page defaultCodec="html" %>
<tr>
    <td><b>${label}</b></td>
    <td>
        <g:if test="${label.equals('Computer Vendor')}">
            <g:link controller="vendor" action="detail" id="${computer.computerVendor.id}">
                ${computer.computerVendor.getDisplayString()}
            </g:link>
        </g:if>

        <g:elseif test="${value}">
            ${value}
        </g:elseif>
        <g:else>
            --
        </g:else>

    </td>
</tr>



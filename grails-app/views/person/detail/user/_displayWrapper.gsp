<%@ page defaultCodec="html" %>
<!-- Template: person/detail/user/displayWrapper.gsp -->
<tr>
    <td><b>${label}</b></td>
    <td>
        <g:if test="${value}">
            <g:link controller="user" id="${value.id}" action="detail">
                ${value.getDisplayString()}
            </g:link>
        </g:if>
        <g:else>
            --
        </g:else>

    </td>
</tr>



<%@ page defaultCodec="html" %>
    <tr>
        <td class="control-group ${invalid ? 'error' : ''}">
            <label for="${property}">${label}${required ? ' *': ' '}</label>
        </td>
        <td>
            <g:countrySelect value="${value ? value : 'GER'}" name="address.country" noSelection="['':'-Choose your country-']"/>
                <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
        </td>
    </tr>



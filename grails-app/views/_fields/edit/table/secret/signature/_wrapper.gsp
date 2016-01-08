<%@ page defaultCodec="html" %>
<tr>
    <td class="control-group ${invalid ? 'error' : ''}">
        <label for="${property}">${label}${required ? ' *': ' '}</label>
    </td>
    <td>
        <g:passwordField name="signature" value="${user?.signature}"/>
        <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
    </td>
</tr>

<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Template: /_fields/list/secret/password/_displayWrapper.gsp -->
<td>
    <g:if test="${bean.passwordExpired}">
        <span class="label label-danger"><g:message code="user.password.expired"/></span>
    </g:if>
    <g:else>*****</g:else>

</td>

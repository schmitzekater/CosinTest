<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Template: /_fields/list/username/_displayWrapper.gsp -->
<td>
    ${value}
    <g:if test="${bean.accountLocked}">
        <span class="glyphicon glyphicon-exclamation-sign" style="color: red" aria-hidden="true"
              title='<g:message code="user.account.locked"/>'></span>
    </g:if>
    <g:if test="${!bean.enabled}">
        <span class="glyphicon glyphicon-ban-circle" style="color: red" aria-hidden="true"
              title='<g:message code="user.account.disabled"/>'></span>
    </g:if>
</td>
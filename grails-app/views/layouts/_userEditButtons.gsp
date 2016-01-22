<sec:link action="changeUserPassword" id="${model.id}"
          expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
    <span class="glyphicon glyphicon-edit" style="color:green" aria-hidden="true"
          title='<g:message code="user.change.userPassword"/>'></span>
</sec:link>

<g:if test="${model.enabled}">
    <sec:link action="disableAccount" id="${model.id}"
              expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
        <span onclick="return confirm('${message(code: 'remove.confirmation.question')}')"
              class="glyphicon glyphicon-ban-circle" style="color:red" aria-hidden="true"
              title='<g:message code="user.disable.account"/>'></span>
    </sec:link>
</g:if>
<g:else>
    <sec:link action="enableAccount" id="${model.id}"
              expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
        <span class="glyphicon glyphicon-ok-circle" style="color:green" aria-hidden="true"
              title='<g:message code="user.ensable.account"/>'></span>
    </sec:link>
</g:else>
<g:if test="${model.accountLocked}">
    <sec:link action="unlockAccount" id="${model.id}"
              expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
        <span class="glyphicon glyphicon-ok-sign" style="color:green" aria-hidden="true"
              title='<g:message code="user.unlock.account"/>'></span>
    </sec:link>
</g:if>
<g:else>
    <sec:link action="lockAccount" id="${model.id}"
              expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')">
        <span onclick="return confirm('${message(code: 'remove.confirmation.question')}')"
              class="glyphicon glyphicon-exclamation-sign" style="color:red" aria-hidden="true"
              title='<g:message code="user.lock.account"/>'></span>
    </sec:link>
</g:else>
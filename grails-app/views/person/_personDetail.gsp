<table class="table table-striped">
   <tbody>
        <f:with bean="person">
            <f:display property="lastName"/>
            <f:display property="firstName"/>
            <f:display property="email"/>
            <f:display property="user.userId"/>
        </f:with>

   </tbody>
</table>
<g:form controller="person" id="${person.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>
%{--Falls wir das Template unter User aufrufen, soll uns nicht nochmal der User begegnen!!--}%
<g:if test="${controllerName.compareToIgnoreCase('user')!=0}">
    <g:if test="${person.user != null}">
        <h3><g:message code="default.show.label" args="['User']"/></h3>
        <g:render template="/user/userDetail" model="[user: person.user]"/>
    </g:if>
    <g:else>
        <p>No User associated.</p>
    </g:else>
</g:if>
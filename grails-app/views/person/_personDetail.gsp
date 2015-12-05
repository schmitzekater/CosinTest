<table class="table table-striped">
   <tbody>
        <f:with bean="person">
            <f:display property="lastName"/>
            <f:display property="firstName"/>
            <f:display property="email"/>
            <f:display property="user"/>
        </f:with>

   </tbody>
</table>
<g:form controller="person" id="${person.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>
%{--Falls wir das Template unter User aufrufen, soll uns nicht nochmal der User begegnen!!--}%
<g:if test="${controllerName.compareToIgnoreCase('user')!=0}">
    %{--Wenn ein User assoziiert ist, kommt hier ein Link zum User rein.--}%
    <g:if test="${person.user != null}">
        <h3><g:message code="default.associated.label" args="['User']"/></h3>
        <g:render template="/user/userDetail" model="[user: person.user]"/>
    </g:if>
    %{--Wenn es keinen User gibt, wird auch das angezeigt.--}%
    <g:else>
        <p>No User associated.</p>
    </g:else>
</g:if>
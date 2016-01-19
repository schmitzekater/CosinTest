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
<sec:link action="edit" class="btn btn-primary" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
          id="${person.id}" title="${message(code: "edit.person")}" controller="person">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>
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
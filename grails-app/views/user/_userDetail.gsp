<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.11.2015
  Time: 19:38
--%>
<f:with bean="user">
    <f:display property="username" wrapper="detail"/>
    <f:display property="signature" wrapper="detail/secret"/>
    <f:display property="person" wrapper="detail/link/person"/>
    <g:render template="/user/userRoleGroup" model="${user}"/>
</f:with>
<sec:link action="edit" class="btn btn-primary" expression="hasRole('ROLE_DELETE')"
          id="${user.id}" title="${message(code: "edit.user")}" controller="user">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>
%{--Falls wir das Template unter Person aufrufen, soll uns nicht nochmal die Person begegnen!!--}%
<g:if test="${controllerName.compareToIgnoreCase('person')!=0}">
%{--Da ein User immer eine Person haben muss, können wir uns den Test auf eine Person sparen, und können diese direkt anzeigen.--}%
    <h3><g:message code="default.associated.label" args="['Person']"/></h3>
    <g:render template="/person/personDetail" model="[person: user.person]"/>
</g:if>
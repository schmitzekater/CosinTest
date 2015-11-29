<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.11.2015
  Time: 19:38
--%>

<table class="table table-striped">
    <tbody>
        <f:with bean="user">
            <f:display property="userId"/>
            <f:display property="signature"/>
            <f:display property="person.email"/>
            <f:display property="dateCreated"/>
            <f:display property="isAdmin"/>
        </f:with>
    </tbody>
</table>
<g:form controller="user" id="${user.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>
%{--Falls wir das Template unter Person aufrufen, soll uns nicht nochmal die Person begegnen!!--}%
<g:if test="${controllerName.compareToIgnoreCase('person')!=0}">
%{--Da ein User immer eine Person haben muss, können wir uns den Test auf eine Person sparen, und können diese direkt anzeigen.--}%
    <h3><g:message code="default.associated.label" args="['Person']"/></h3>
    <g:render template="/person/personDetail" model="[person: user.person]"/>
</g:if>
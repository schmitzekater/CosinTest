<table class="table table-striped">
    <tbody>
        <f:with bean="software">
            <f:display property="softwareName" wrapper="detail"/>
            <f:display property="softwareVersion" wrapper="detail"/>
            <f:display property="softwareVendor" wrapper="detail/link/vendor"/>
            <f:display property="system" wrapper="detail/link/system"/>
            </f:with>
        </tbody>
</table>
<sec:link action="edit" class="btn btn-primary" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
          id="${software.id}" title="${message(code: "edit.software")}" controller="software">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>
    <hr/>
<h3><g:message code="qualification.list.label"/> </h3>
%{--Display the sorted qualifications with the newest Qualification on Top--}%
<g:render template="/layouts/listQualifications" model="[model: software.qualifications.sort { it.qualificationDate }.reverse()]"/>

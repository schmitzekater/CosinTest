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
<sec:ifAnyGranted roles="'ROLE_DELETE, ROLE_EDIT, ROLE_CREATE'">
    <g:form controller="software" id="${software.id}">
        <g:actionSubmit action="edit" class="btn btn-primary"
                        value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>
</sec:ifAnyGranted>
    <hr/>
<h3><g:message code="qualification.list.label"/> </h3>
%{--Display the sorted qualifications with the newest Qualification on Top--}%
<g:render template="/layouts/listQualifications" model="[model: software.qualifications.sort { it.qualificationDate }.reverse()]"/>

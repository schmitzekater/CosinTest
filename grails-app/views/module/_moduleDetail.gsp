<table class="table table-striped">
    <tbody>
        <f:with bean="module">
            <f:display property="moduleName" wrapper="detail"/>
            <f:display property="moduleSerial" wrapper="detail"/>
            <f:display property="moduleModel" wrapper="detail"/>
            <f:display property="moduleFirmware" wrapper="detail"/>
            <f:display property="moduleVendor" wrapper="detail/link/vendor"/>
            <f:display property="moduleType" wrapper="detail"/>
            <f:display property="moduleConnection" wrapper="detail"/>
            <f:display property="unit" wrapper="detail/link/unit"/>
            <g:if test="${module.needsCalibration==true}">
                <f:display property="needsCalibration"  wrapper="detail/date/calibInterval"/>
                <f:display property="lastCalibration" wrapper="detail/date"/>
                <f:display property="nextCalibration" wrapper="detail/date/colored"/>
            </g:if>
            <f:display property="productiveDate" wrapper="detail/date"/>
            <g:if test="${module.retirementDate != null}">
                <f:display property="retirementDate" wrapper="detail/date"/>
            </g:if>
            </f:with>
        </tbody>
</table>
<sec:link action="edit" class="btn btn-primary" expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"
          id="${module.id}" title="${message(code: "edit.module")}" controller="module">
    <g:message code='default.button.edit.label' default='Edit'/>
</sec:link>
<hr/>
<h3><g:message code="qualification.list.label"/> </h3>
%{--Display the sorted qualifications with the newest Qualification on Top--}%
<g:render template="/layouts/listQualifications" model="[model: module.qualifications.sort { it.qualificationDate }.reverse()]"/>

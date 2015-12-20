<table class="table table-striped">
    <tbody>
        <f:with bean="module">
            <f:display property="moduleName"/>
            <f:display property="moduleSerial"/>
            <f:display property="ModuleModel"/>
            <f:display property="moduleFirmware"/>
            <f:display property="moduleVendor"/>
            <f:display property="moduleType"/>
            <f:display property="moduleConnection"/>
            <f:display property="unit"/>
            <g:if test="${needsCalibration}">
                <f:display property="needsCalibration"/>
                <tr>
                    <td><label class="label" for="${calibInterval}"/>${label}</td>
                    <td>${module.getCalibrationDisplayString()}</td>
                </tr>
                <f:display property="calibInterval"/>
                <f:display property="calibPeriod"/>
                <f:display property="lastCalibration"/>
                <f:display property="nextCalibration"/>
            </g:if>
            <f:display property="productiveDate"/>
            <g:if test="${retireDate!=null}">
                <f:display property="retireDate"/>
            </g:if>
            </f:with>
        </tbody>
</table>
<g:form controller="module" id="${module.id}">
    <g:actionSubmit action="edit" class="btn btn-primary"
                    value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
</g:form>
<hr/>
<h3><g:message code="qualification.list.label"/> </h3>
%{--Display the sorted qualifications with the newest Qualification on Top--}%
<g:render template="/layouts/listQualifications" model="[model: module.qualifications.sort { it.qualificationDate }.reverse()]"/>
<hr/>
<g:render template="/layouts/addQualification"/>
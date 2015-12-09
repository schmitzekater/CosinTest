<%@ page import="de.schmitzekater.Qualification" %>
<g:form controller="Software" action="addQualification" it="${params.id}">
    <g:hiddenField name="id" value="${software.id}"/>
    <fieldset class="form">
        <h2><g:message code="default.add.Qualification"/></h2>
        <g:select from="${Qualification.types}" name="qualificationType" id="QualificationType"/><br/>
        <g:datePicker name="qualificationDate" id="QualificationDate" precision="day"/><br/>
        <g:textArea name="comment" id="QualificationComment"/><br/>

    </fieldset>
    <fieldset class="buttons">
        <input class="save" action="addQualification" type="submit"
               value="${message(code: 'default.button.add.label', default: 'Add')}"/>
    </fieldset>
    <g:uploadForm controller="software" action="saveAttachment" id="QualificationAttachment">
        <input type="file" name="attachment"/>
        <input type="submit"/>
    </g:uploadForm>
</g:form>
<%@ page import="de.schmitzekater.Qualification" %>
<hr/>
<h2><g:message code="default.add.Qualification"/></h2>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addQualification" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset class="well">
           <dl>
                <dt>
                    <label for="QualificationType"><g:message code="qualification.qualificationType.label"/></label>
                </dt>
                <dd>
                    <g:select from="${de.schmitzekater.QualificationType.findAll()}" name="qualificationType"
                              id="QualificationType"/>
                </dd>
                <dt>
                    <label for="QualificationDate"><g:message code="qualification.qualificationDate.label"/></label>
                </dt>
                <dd>
                    <g:datePicker name="qualificationDate" id="QualificationDate" precision="day" relativeYears="[-3..2]"/>
                </dd>
                <dt>
                    <label for="QualificationComment"><g:message code="qualification.comment.label"/></label>
                </dt>
                <dd>
                    <g:textArea name="comment" id="QualificationComment"/>
                </dd>
                <dt>
                    <label for="QualificationAttachment"><g:message code="qualification.qualificationAttachment.label"/></label>
                </dt>
                <dd>
                    <g:uploadForm controller="${controllerName}" action="saveAttachment" id="QualificationAttachment">
                        <input type="file" name="attachment"/>
                        <input type="submit"/>
                    </g:uploadForm>
                </dd>
               <hr/>
               <input class="save btn btn-primary" action="addQualification" type="submit"
                      value="${message(code: 'default.button.add.label', default: 'Add')}"/>
            </dl>
        </fieldset>
    </g:form>
</div>
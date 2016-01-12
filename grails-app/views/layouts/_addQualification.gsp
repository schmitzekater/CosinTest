<%@ page import="de.schmitzekater.Qualification" %>
<hr/>
<h2><g:message code="default.add.Qualification"/></h2>
    <g:form controller="${controllerName}" action="addQualification" it="${params.id}" enctype="multipart/form-data">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset class="form">
            <table class="table-condensed table-striped">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="control-group ${invalid ? 'error' : ''}">
                            <label for="QualificationType"><g:message
                                    code="qualification.qualificationType.label"/></label>
                        </div>
                    </div>

                    <div class="col-xs-6">
                        <div class="controls">
                            <g:select from="${de.schmitzekater.QualificationType.findAll()}" name="qualificationType"
                                      id="QualificationType"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6">
                        <div class="control-group ${invalid ? 'error' : ''}">
                            <label for="QualificationDate"><g:message
                                    code="qualification.qualificationDate.label"/></label>
                        </div>
                    </div>

                    <div class="col-xs-6">
                        <div class="controls">
                            <g:datePicker name="qualificationDate" id="QualificationDate" precision="day"
                                          relativeYears="[-3..2]"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6">
                        <div class="control-group ${invalid ? 'error' : ''}">
                            <label for="QualificationComment"><g:message code="qualification.comment.label"/></label>
                        </div>
                    </div>

                    <div class="col-xs-6">
                        <div class="controls">
                    <g:textArea name="comment" id="QualificationComment"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6">
                        <div class="control-group ${invalid ? 'error' : ''}">
                            <label for="QualificationAttachment"><g:message
                                    code="qualification.qualificationAttachment.label"/></label>
                        </div>
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="controls">
                    <input type="file" name="attachment"/>
                    </div>
                </div>
            </div>

            </table>
            <input class="save btn btn-primary" action="addQualification" type="submit"
                      value="${message(code: 'default.button.add.label', default: 'Add')}"/>

        </fieldset>
    </g:form>

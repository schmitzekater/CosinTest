<%@ page import="de.schmitzekater.QualificationType; de.schmitzekater.Qualification" %>
<hr/>
<h2><g:message code="default.add.Qualification"/></h2>
<g:form controller="${controllerName}" action="addQualification" enctype="multipart/form-data">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset class="form">
            <f:with bean="qualification">
                <table>
                    <f:field property="qualificationType" wrapper="edit/table/"
                             widget="edit/widgets/qualificationType"/>
                    <f:field property="qualificationDate" wrapper="edit/table" widget="edit/date"/>
                    <f:field property="comment" wrapper="edit/table" widget="edit/widgets/textArea"/>
                    <f:field property="attachment" wrapper="edit/table" widget="edit/widgets/file"/>
                </table>
            </f:with>
            <input class="save btn btn-primary" type="submit"
                      value="${message(code: 'default.button.add.label', default: 'Add')}"/>

        </fieldset>
    </g:form>

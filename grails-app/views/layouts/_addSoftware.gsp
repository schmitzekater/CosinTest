<%@ page import="de.schmitzekater.Software" %>
<hr/>
<h4><g:message code="default.add.Software"/></h4>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addSoftware" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <f:field property="software" wrapper="edit" widget="detail/select/software"/>
            <input class="save btn btn-primary" action="addSoftware" type="submit"
                   value="${message(code: 'default.button.add.label', default: 'Add')}"/>
        </fieldset>

    </g:form>
</div>
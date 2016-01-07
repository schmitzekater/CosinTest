<%@ page import="de.schmitzekater.Module" %>
<hr/>
<h4><g:message code="default.add.Module"/></h4>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addModule" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <f:field property="modules" wrapper="edit" widget="/edit/queries/module"></f:field>
            <input class="save btn btn-success" action="addModule" type="submit"
                   value="${message(code: 'default.button.add.mini.label', default: 'Add')}"  title="${message(code: 'button.add.title', default: 'Add')}"/>
        </fieldset>

    </g:form>
    <br/>

</div>


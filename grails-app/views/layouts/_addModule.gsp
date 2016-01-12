<%@ page import="de.schmitzekater.Module" %>
<hr/>
<h4><g:message code="default.add.Module"/></h4>
<sec:ifAnyGranted roles="'ROLE_EDIT, ROLE_CREATE'">
    <div class="container-fluid">
        <g:form controller="${controllerName}" action="addModule" it="${params.id}">
            <g:hiddenField name="id" value="${params.id}"/>
            <fieldset>
                <f:field property="modules" wrapper="edit/module" widget="/edit/queries/module"></f:field>
            </fieldset>
        </g:form>
    </div>
</sec:ifAnyGranted>

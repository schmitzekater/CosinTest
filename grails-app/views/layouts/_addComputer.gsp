<%@ page import="de.schmitzekater.Computer" %>
<hr/>
<h4><g:message code="default.add.Computer"/></h4>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addComputer" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <g:select name="computer" from="${de.schmitzekater.Computer.all}"
                      optionKey="id" optionValue="computerName" noSelection="${['null':'<N/A>']}"/>
            <g:select name="computerRole" from="${de.schmitzekater.ComputerRole.all}"
                      optionKey="id" optionValue="role" noSelection="${['null':'<N/A>']}"/>

            <input class="save btn btn-primary" action="addComputer" type="submit"
                   value="${message(code: 'default.button.add.label', default: 'Add')}"/>
        </fieldset>

    </g:form>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
</div>


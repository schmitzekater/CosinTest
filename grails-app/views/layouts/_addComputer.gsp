<%@ page import="de.schmitzekater.Computer" %>
<hr/>
<h4><g:message code="default.add.Computer"/></h4>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addComputer" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <table class="table-condensed">
                <tr>
                    <td>
                        <label for="computer">
                            <g:message code="computer.label"/>
                        </label>
                    </td>
                    <td>
                        <g:select name="computer" from="${de.schmitzekater.Computer.all}"
                                  optionKey="id" optionValue="computerName" noSelection="${['null':'<N/A>']}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="computerRole">
                            <g:message code="computer.computerRole.label"/>
                        </label>
                    </td>
                    <td>
                        <g:select name="computerRole" from="${de.schmitzekater.ComputerRole.all}"
                                  optionKey="id" optionValue="role" noSelection="${['null':'<N/A>']}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="save btn btn-primary" action="addComputer" type="submit"
                               value="${message(code: 'default.add.Computer', default: 'Add')}" title="${message(code: 'add.computer.to.system', default: 'Add')}"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </g:form>
    <br/>
</div>


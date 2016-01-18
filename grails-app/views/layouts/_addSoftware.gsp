<%@ page import="de.schmitzekater.Software" %>
<hr/>
<h4><g:message code="default.add.Software"/></h4>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addSoftware" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <table class="table-condensed">
                <f:field property="software" wrapper="edit/table" widget="detail/select/software"/>
                <tr>
                    <td colspan="2">
                        <input class="save btn btn-primary" action="addSoftware" type="submit"
                               value="${message(code: 'default.add.Software', default: 'Add')}" title="${message(code: 'add.software.to.system', default: 'Add')}"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </g:form>
</div>
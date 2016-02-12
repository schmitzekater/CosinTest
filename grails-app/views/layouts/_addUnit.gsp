<%@ page import="de.schmitzekater.Unit" %>
<hr/>
<h4><g:message code="default.add.Unit"/></h4>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addUnit">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <table class="table-condensed">
                <f:field property="unit" wrapper="edit/table" widget="detail/select/unit"/>
                <tr>
                    <td colspan="2">
                        <input class="save btn btn-primary" type="submit"
                               value="${message(code: 'default.add.Unit', default: 'Add')}" title="${message(code: 'add.unit.to.system', default: 'Add')}"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </g:form>
</div>
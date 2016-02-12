<%@ page import="de.schmitzekater.Module" %>
<hr/>
<h4 onclick='$("#addModule").toggle()' title="Show/Hide"> <g:message code="default.add.Module"/></h4>
<sec:access expression="hasAnyRole('ROLE_EDIT,ROLE_CREATE')">

    <div class="container-fluid" id="addModule" style="display:none">
        <g:form controller="${controllerName}" action="addModule">
            <g:hiddenField name="id" value="${params.id}"/>
            <fieldset>
                <table class="table-condensed">
                    <f:field property="modules" wrapper="edit/table" widget="/edit/queries/module"/>
                    <tr>
                        <td colspan="2">
                            <input class="save btn btn-primary" type="submit"
                                   value="${message(code: 'default.add.Module', default: 'Add')}" title="${message(code: 'add.module.to.unit', default: 'Add')}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </g:form>
    </div>
</sec:access>

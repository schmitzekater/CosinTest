<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 04.02.2016
  Time: 14:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="system.retire.system"/></title>
    <asset:javascript src="jquery-ui.min.js"/>
    <asset:stylesheet src="jquery-ui.min.css"/>
    <asset:stylesheet src="jquery-ui.structure.min.css"/>
    <asset:stylesheet src="jquery-ui.theme.min.css"/>
    <script>
        $(function () {
            $("#datepicker").datepicker({
                dateFormat: "yy-mm-dd",
                maxDate: "1d",
                defaultDate: -2
            });
        });
    </script>
</head>

<body>
<h2><g:message code="system.retire.system"/></h2>
<g:form id="${system.id}" controller="system" action="retire">
    <fieldset>
        <table class="table-condensed">
            <tr>
                <td></td>
                <td><label for="retirementDate"></label><input type="text" name="retirementDate" id="datepicker"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="save btn btn-primary" type="submit"
                           value="${message(code: 'system.retire.system', default: 'Retire')}"
                           title="${message(code: 'system.retire.system', default: 'Retire')}"/>
                    <cos:cancelButton/>
                </td>
            </tr>
        </table>
    </fieldset>
</g:form>
<div class="container-fluid">
    <g:form controller="${controllerName}" action="addUnit" it="${params.id}">
        <g:hiddenField name="id" value="${params.id}"/>
        <fieldset>
            <table class="table-condensed">
                <f:field property="unit" wrapper="edit/table" widget="detail/select/unit"/>
                <tr>
                    <td colspan="2">
                        <input class="save btn btn-primary" action="addUnit" type="submit"
                               value="${message(code: 'default.add.Unit', default: 'Add')}"
                               title="${message(code: 'add.unit.to.system', default: 'Add')}"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </g:form>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 04.02.2016
  Time: 14:41

  GSP to display the entry for the retirementDate of a System.
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
                dateFormat: "yy-mm-dd",         // format that the service expects.
                maxDate: "1d",                  // Maximum tomorrow
                defaultDate: -1                 // testing
            });
        });
    </script>
</head>

<body>
<h2><g:message code="system.retire.system"/></h2>
    <div id="warning" class="alert alert-warning" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign"></span>
        <g:message code="warning.cannot.be.undone"/>
    </div>
<g:form id="${system.id}" controller="system" action="retire">
    <fieldset>
        <div class="control-group ${invalid ? 'error' : ''}">
            <label for="retirementDate"><g:message code="retirementDate.label"/></label>
        </div>
        <div class="control-box">

            <span class="btn btn-default"><input type="text" name="retirementDate" id="datepicker"></span>

                <input class="save btn btn-primary" type="submit"
                       value="${message(code: 'system.retire.system', default: 'Retire')}"
                       title="${message(code: 'system.retire.system', default: 'Retire')}"/>
                <cos:cancelButton/>
        </div>
</fieldset>
</g:form>
</body>
</html>
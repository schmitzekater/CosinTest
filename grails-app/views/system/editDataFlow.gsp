<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 31.01.2016
  Time: 12:37
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="system.edit.dataFlow"/></title>
</head>

<body>
<g:form controller="system" action="editDataFlowFile" id="${system.id}" enctype="multipart/form-data">
    <g:hiddenField name="id" value="${system.id}"/>
    <fieldset class="form">
            <div class="row">
                <div class="col-xs-6">
                    <div class="control-group ${invalid ? 'error' : ''}">
    <label for="dataFlow"><g:message
            code="system.dataFlow.label"/></label>
    </div>
</div>
</div>
    <div class="col-xs-6">
        <div class="controls">
            <input type="file" name="dataflow"/>
        </div>
    </div>
    </div>
    <input class="save btn btn-primary"  type="submit"
           value="${message(code: 'default.button.save.label', default: 'Add')}"/>
    </fieldset>
</g:form>
</body>
</html>
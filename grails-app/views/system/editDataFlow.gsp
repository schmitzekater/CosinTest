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
<h2><g:message code="system.edit.dataFlow"/></h2>
<g:if test="${system.dataFlow}">
    <div id="warning" class="alert alert-warning" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign"></span>
            <g:message code="system.warning.dataflow.exists"/>

    </div>
</g:if>
<g:form controller="system" action="editDataFlowFile" id="${system.id}" enctype="multipart/form-data">
    <g:hiddenField name="id" value="${system.id}"/>
    <fieldset class="form">
        <div class="control-group ${invalid ? 'error' : ''}">
            <label for="dataflow">
                <g:message code="system.dataFlow.label"/>
            </label>
        </div>
        <div class="controls">
            <span class="btn btn-default btn-file"><input type="file" name="dataflow"  title="${message(code: "hint.file.browse")}"/></span>
            <input class="save btn btn-primary"  type="submit"
                   value="${message(code: 'default.button.save.label', default: 'Save')}"
                    title="${message(code: 'system.save.dataflow')}"/>
            <cos:cancelButton/>
        </div>
    </div>

    </fieldset>
</g:form>
</body>
</html>
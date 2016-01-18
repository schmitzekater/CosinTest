<%@ page defaultCodec="html" %>
<div class="row">
    <div class="col-xs-6">
        <div class="control-group ${invalid ? 'error' : ''}">
            <label for="${property}"><g:message code="module.availableModules"/>${required ? ' *' : ' '}</label>
        </div>
    </div>

    <div class="col-xs-6">
        <div class="controls">
            <%=widget%>
            <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
        </div>
    </div>

</div>


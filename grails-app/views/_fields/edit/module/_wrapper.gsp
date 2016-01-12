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
            <input class="save btn btn-success" action="addModule" type="submit"
                   value="${message(code: 'default.button.add.mini.label', default: 'Add')}"
                   title="${message(code: 'button.add.title', default: 'Add')}"/>
        </div>
    </div>

</div>


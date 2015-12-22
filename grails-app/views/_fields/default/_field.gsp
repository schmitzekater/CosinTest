<%@ page defaultCodec="html" %>
<div class="row">
    <div class="col-xs-4">
        <h4>
            <div class="control-group ${invalid ? 'error' : ''}">
                <label class="control-label" for="${property}">${label}${required? ' *': ''} </label>
            </div>
        </h4>
    </div>

    <div class="col-xs-8">
        <h4>
            <div class="controls">
                <%=widget%>
                <g:if test="${invalid}"><span class="help-inline">${errors.join('<br>')}</span></g:if>
            </div>
        </h4>
    </div>

</div>


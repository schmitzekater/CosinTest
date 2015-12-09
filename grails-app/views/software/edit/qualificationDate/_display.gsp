<%@ page defaultCodec="html" %>
<div class="row-fluid">
    <div class="col-xs-4">
        <h4>
            <div class="control-group ${invalid ? 'error' : ''}">
                <g:if test="${required}">
                    <label class="label label-primary" for="${property}">${label}</label>
                </g:if>
                <g:else>
                    <label class="label label-default" for="${property}">${label}</label>
                </g:else>
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


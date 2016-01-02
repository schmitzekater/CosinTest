<!-- template: _fields/detail/link/system/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <g:link controller="system" action="detail" id="${value.id}">
            ${value.getDisplayString()}
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
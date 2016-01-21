<!-- template: _fields/detail/link/mail/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <a href="mailto:${value}">${value}</a>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
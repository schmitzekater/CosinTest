<!-- template: _fields/detail/link/externally/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <a href="${value}" target="_blank">${value}</a>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
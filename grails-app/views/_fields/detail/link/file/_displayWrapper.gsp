<!-- template: _fields/detail/link/file/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <a href="file://${value}" target="_blank">${value.name}</a>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
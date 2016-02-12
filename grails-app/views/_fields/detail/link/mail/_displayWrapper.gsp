<!-- template: _fields/detail/link/mail/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dl>
    <dt>${label}</dt>
    <dd>
    <g:if test="${value}">
        <a href="mailto:${value}">${value}</a>
    </g:if>
    <g:else>
        --
    </g:else>
    </dd>
</dl>
<!-- template: _fields/detail/link/file/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <g:link controller="common" action="downloadDataflow" id="${bean.id}">${value.name}</g:link>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
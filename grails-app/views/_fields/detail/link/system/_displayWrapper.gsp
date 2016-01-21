<!-- template: _fields/detail/link/system/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <g:each var="system" in="${value}">
            <g:link controller="system" action="detail" id="${system.id}">
                ${system.getDisplayString()}
            </g:link>
            <br/>
        </g:each>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
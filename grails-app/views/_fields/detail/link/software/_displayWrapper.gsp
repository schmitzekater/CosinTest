<!-- template: _fields/detail/link/software/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <g:each var="software" in="${value}">
            <g:link controller="software" action="detail" id="${software.id}">
                ${software.getDisplayString()}
            </g:link>
            <br/>
        </g:each>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>


<!-- template: _fields/detail/link/person/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        <g:each var="person" in="${value}">
            <g:link controller="person" action="detail" id="${person.id}">
                ${person.getDisplayString()}
            </g:link>
            <br/>
        </g:each>
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
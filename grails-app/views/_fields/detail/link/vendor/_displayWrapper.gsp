%{--<!-- template: _fields/detail/link/vendor/_displayWrapper.gsp -->--}%
<%@ page contentType="text/html;charset=UTF-8" %>
<dl>
    <dt>${label}</dt>
    <dd>
        <g:if test="${value}">
            <g:link controller="vendor" action="detail" id="${value.id}">
                ${value.getDisplayString()}
            </g:link>
        </g:if>
        <g:else>
            --
        </g:else>
    </dd>
</dl>
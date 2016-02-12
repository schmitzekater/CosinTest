<%@ page defaultCodec="html;charset=UTF-8" %>
%{--<!-- template: _fields/detail/date/_displayWrapper.gsp -->--}%
<dl>
    <dt>${label}</dt>
    <dd>
        <g:if test="${value}">
            <g:formatDate format="yyyy-MM-dd" date="${value}"/>
        </g:if>
        <g:else>
            --
        </g:else>
    </dd>
</dl>



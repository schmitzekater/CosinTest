<%@ page defaultCodec="html;charset=UTF-8" %>
<!-- template: _fields/detail/secret/_displayWrapper.gsp -->
<dl>
    <dt>${label}</dt>
    <dd>
        <g:if test="${value}">
            *******
        </g:if>
        <g:else>
            --
        </g:else>
    </dd>
</dl>


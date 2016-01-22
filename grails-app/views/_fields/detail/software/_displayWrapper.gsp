<%@ page defaultCodec="html;charset=UTF-8" %>
<!-- template: _fields/detail/_displayWrapper.gsp -->
<dt>${label}
<dd>
    <g:if test="${value}">
        ${value}
    </g:if>
    <g:else>
        --
    </g:else>
</dd>
</dt>




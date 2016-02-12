<%@ page defaultCodec="html;charset=UTF-8" %>
%{--<!-- template: _fields/detail/date/calibInterval/_displayWrapper.gsp -->--}%
<dl>
    <dt>${label}</dt>
<dd>
    <g:if test="${value}">
        <i><g:message code="calibInterval.interval"/>: </i>${module.getCalibrationDisplayString()}
    </g:if>
    <g:else>
        --
    </g:else>
</dd>
</dl>




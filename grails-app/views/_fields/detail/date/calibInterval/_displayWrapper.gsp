<%@ page defaultCodec="html;charset=UTF-8" %>
<!-- template: _fields/detail/date/calibInterval/_displayWrapper.gsp -->
<dt>${label}
<dd>
    <g:if test="${value}">
        <i><g:message code="calibInterval.interval"/>: </i>${module.getCalibrationDisplayString()}
    </g:if>
    <g:else>
        --
    </g:else>
</dd>
</dt>




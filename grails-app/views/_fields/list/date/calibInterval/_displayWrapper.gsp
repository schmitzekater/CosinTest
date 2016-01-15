<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Template: /_fields/list/date/calibInterval/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        ${bean.getCalibrationDisplayString()}
    </g:if>
    <g:else>
        --
    </g:else>
</td>
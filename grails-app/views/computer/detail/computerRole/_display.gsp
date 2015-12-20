<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 05.12.2015
  Time: 11:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<dt>${label}
<dl>
    <g:if test="${value}">
        ${computer.computerRole.getDisplayString()}
    </g:if>
    <g:else>
        --
    </g:else>
</dl>
</dt>
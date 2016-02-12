<!-- template: _fields/detail/link/auditTrailEvent/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dl>
    <dt>${label}</dt>
    <dd>
    <g:if test="${value}">
        <g:link action="detail" id="${bean.persistedObjectId}" controller="${value}">
            ${value} (ID:${bean.persistedObjectId})
        </g:link>
    </g:if>
    <g:else>
        --
    </g:else>
    </dd>
</dl>

<%@ page defaultCodec="html;charset=UTF-8" %>
<!-- template: _fields/detail/date/_displayWrapper.gsp -->
<dt>${label}
<dd>
    <g:if test="${value}">
        <g:if test="${value<new Date()}">
            <span class="label label-danger">
                <g:formatDate format="yyyy-MM-dd" date="${value}"/>
            </span>
            &nbsp${new Date() - value} <i>(days overdue.)</i>
        </g:if>
        <g:else>
            <span class="label label-success">
                <g:formatDate format="yyyy-MM-dd" date="${value}"/>
            </span>
            <i> (in ${value-new Date()} days.)</i>
        </g:else>
    </g:if>
    <g:else>
    --
    </g:else>
</dd>
</dt>



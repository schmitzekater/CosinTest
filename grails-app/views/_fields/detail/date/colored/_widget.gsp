<g:if test="${value < new Date()}">
    <span class="label label-danger">
        <g:formatDate format="yyyy-MM-dd" date="${value}"/>
    </span>
    ${new Date() - value} <i>(days overdue.)</i>
</g:if>
<g:else>
    <span class="label label-success">
        <g:formatDate format="yyyy-MM-dd" date="${value}"/>
    </span>
    <i>(in ${value - new Date()} days.)</i>
</g:else>
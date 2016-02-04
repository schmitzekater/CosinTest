<%@ page defaultCodec="html;charset=UTF-8" %>
<!-- template: _fields/detail/date/since/_displayWrapper.gsp -->
<g:if test="${value}">
    <g:formatDate format="dd-MMM-yyyy" date="${value}"/>
</g:if>
<g:else>
    --
</g:else>




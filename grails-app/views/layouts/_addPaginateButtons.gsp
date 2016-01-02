%{--Only load paginate buttons if amount of entries is larger than maximum to be displayed--}%
<g:if test="${params.int('max')<count}">
    <div class="paginateButtons">
        <g:message code="default.page.label"/> <g:paginate total="${count}" prev="&lt;" next="&gt;"/>
    </div>
</g:if>

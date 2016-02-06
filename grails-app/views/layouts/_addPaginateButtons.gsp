%{--Only load paginate buttons if amount of entries is larger than maximum to be displayed--}%
<g:if test="${params.int('max')<count}">
    <ul class="pagination pagination-sm">
        %{--Default Pagination overrided in schmitzekater.taglib. Applies Bootstrap-Style to paginate--}%
        <cos:paginate total="${count}" prev="&laquo;" next="&raquo;"/>
    </ul>
</g:if>

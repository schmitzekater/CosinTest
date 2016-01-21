<!-- Template: /_fields/list/link/person/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">
        <g:each var="person" in="${value}">
            <g:link controller="person" action="detail" id="${person.id}">
                ${person.getDisplayString()}
            </g:link>
            <br/>
        </g:each>
    </g:if>
    <g:else>
        --
    </g:else>
</td>
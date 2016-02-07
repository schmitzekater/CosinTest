<!-- Template: /_fields/list/link/system/_displayWrapper.gsp -->
<td>
    <g:if test="${value}">%{--
        <g:if test="${!(value.size()>2)}">--}%
            <g:each var="system" in="${value}">
                <g:link controller="system" action="detail" id="${system.id}">
                    ${system.getDisplayString()}
                </g:link>
                <br/>
            </g:each>%{--
        </g:if>--}%
       %{-- <g:else>
            <g:link controller="system" action="detail" id="${value[0].id}">
                ${value[0].getDisplayString()}
            </g:link>
            <br/>
            <g:link controller="system" action="detail" id="${value[1].id}">
                ${value[1].getDisplayString()}
            </g:link>
            <br/>
            <g:link action="detail" id="${bean.id}">...${value.size()-2} more</g:link>
        </g:else>--}%
    </g:if>
    <g:else>
        --
    </g:else>
</td>
<!-- template: _fields/detail/link/person/_displayWrapper.gsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<dl>
    <dt>${label}</dt>
    <dd>
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
    </dd>
</dl>
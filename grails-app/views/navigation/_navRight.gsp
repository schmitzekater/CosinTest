<%@ page import="de.SchmitzekaterTagLib" %>
<div class="col-md-4">
    <h2><g:message code="default.right.sidebar"/></h2>
    <g:if test="${cos.navExists(loc: 'Right')}">
        <g:render template="${controllerName}Right"/>
        gefunden
    </g:if>
    <g:else>
        Nix da
    </g:else>
</div>
<%@ page import="de.schmitzekater.Software" %>
<!-- template: _fields/detail/select/software/_widget.gsp -->
<g:if test="${computer!=null}"><g:set var="model" value="${computer}"/> </g:if>
<g:if test="${system!=null}"><g:set var="model" value="${system}"/> </g:if>
<g:select name="software" from="${Software.getAvailableSoftware(model)}"
          optionKey="id" noSelection="${['null': '<N/A>']}"/>
<!-- template: _fields/edit/queries/person/_widget.gsp -->
<%@ page import="de.schmitzekater.Person" %>
<g:select name="${property}" from="${Person.getAll()}"
          optionKey="id"  noSelection="${['null':'<N/A>']}" multiple="false"/>
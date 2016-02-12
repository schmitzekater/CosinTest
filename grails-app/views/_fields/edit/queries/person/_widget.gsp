<!-- template: _fields/edit/queries/person/_widget.gsp -->
<%@ page import="de.schmitzekater.Person" %>
<g:select name="${property}" from="${Person.getAvailablePersons()}"
          optionKey="id" noSelection="${['null': '<N/A>']}"/>
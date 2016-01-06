<!-- template: _fields/edit/queries/person/_widget.gsp -->
<%@ page import="de.schmitzekater.Person" %>
<g:select name="person" from="${Person.getAvailablePersons()}"
          optionKey="id" optionValue="lastName" noSelection="${['null':'<N/A>']}"></g:select>
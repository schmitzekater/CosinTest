<!-- template: _fields/edit/queries/person/supervisor/_widget.gsp -->
<%@ page import="de.schmitzekater.Person" %>
<g:select name="supervisor" from="${de.schmitzekater.Person.getAvailableSupervisors()}"
          optionKey="id" optionValue="${getDisplayString}" noSelection="${['null':'<N/A>']}"></g:select>
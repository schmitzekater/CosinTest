<!-- template: _fields/edit/queries/module/_widget.gsp -->
<%@ page import="de.schmitzekater.Module" %>
<g:select name="module" from="${Module.getAvailableModules()}"
          optionKey="id" optionValue="moduleName" noSelection="${['null':'<N/A>']}"></g:select>
<%@ page import="de.schmitzekater.*" %>
<g:select name="${property}" from="${type.list()}"
          optionKey="id" noSelection="${['null': '<N/A>']}"/>
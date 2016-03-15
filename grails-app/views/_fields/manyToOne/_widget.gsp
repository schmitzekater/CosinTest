<%-- Default for Many-To-One Relationsships. Needed to display the value N/A for null option --%>

<%@ page import="de.schmitzekater.*" %>
<g:select name="${property}" from="${type.list()}" value="${value?.id}"
          optionKey="id" noSelection="${['null': '<N/A>']}"/>
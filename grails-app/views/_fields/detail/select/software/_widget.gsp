<%@ page import="de.schmitzekater.Software" %>
<!-- template: _fields/detail/select/software/_widget.gsp -->
<g:select name="software" from="${Software.getAvailableSoftware(computer)}"
          optionKey="id" noSelection="${['null': '<N/A>']}"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<!-- Template: /_fields/list/file/auditTrailEvent/_displayWrapper.gsp -->
<td>${value ? value.substring(value.lastIndexOf('\\')+1, value.length())  : 'null'}</td>
<%-- get only the filename to display it in Audit Trail --%>
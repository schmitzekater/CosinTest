<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 19.01.2016
  Time: 17:04
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.add.Qualification"/></title>
</head>

<body>
<g:render template="/layouts/addQualification" model="[qualification: new de.schmitzekater.Qualification()]"/>
</body>
</html>
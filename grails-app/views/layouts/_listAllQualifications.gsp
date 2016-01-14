<%--
  Created by IntelliJ IDEA.
  User: schmitza
  Date: 14.01.2016
  Time: 09:48
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Qualification List</title>
</head>

<body>
<g:render template="/layouts/listQualifications"
          model="[model: module.qualifications.sort { it.qualificationDate }.reverse()]"/>
</body>
</html>
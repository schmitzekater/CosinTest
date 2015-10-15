<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 15.10.2015
  Time: 18:05
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>System Details</title>
    <meta name="layout" content="main" />
</head>

<body>
    <h1>System Details for ${systems.systemName}</h1>
    <table>
        <thead>
            <tr>
                <td>System Name: </td><td>${systems.systenName}</td>
            </tr>
        <tr>
            <td>System Owner: </td><td>${systems.systemOwner.lastName}, ${systems.systemOwner.firstName}</td>
        </tr>
        </thead>
    </table>
</body>
</html>
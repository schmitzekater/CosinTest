<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 03.02.2016
  Time: 19:32
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="de.schmitzekater.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title></title>
    <style  type="text/css">
    @page {
        size: 210mm 297mm;
    }
    </style>
</head>

<body>
    <h1>Testueberschrift</h1>
    <p>Ueberblich über System ${system.systemName}</p>
    <table>
        <tr>
            <td>${system.systeName.label}</td><td>${system.systemName}</td>
        </tr>
        <tr>
            <td>${system.systemOwner.label}</td><td>${system.systemOwner}</td>
        </tr>
    </table>
    <p>Blablaba</p>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 10.10.2015
  Time: 14:09
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Personenliste</title>
    <meta name="layout" content="main"/>

</head>

<body role="document">
<div class="container">
    <div class="row">
        <div class="col-md-2"><!-- linke Spalte -->
        <!-- TODO:
                Hier einen g:render einbauen!
                -->
        </div>

        <div class="col-md-6"><!-- content mitte -->
        <g:render template="personList"/>

        </div>

        <div class="col-md-4">
            <h2>Sitemap rechts</h2>
            <g:render template="/navigation/navMain"/>
        </div>
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
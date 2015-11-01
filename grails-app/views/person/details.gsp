<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 21.10.2015
  Time: 20:33
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Details</title>
    <meta name="layout" content="main"/>
</head>

<body role="document">
<div class="container">
    <div class="row">
        <g:render template="personLeft"/>

        <div class="col-md-6"><!-- content mitte -->
        <g:render template="personDetails"/>
        </div>

        <div class="col-md-4">
            <h2>Sitemap rechts</h2>
        </div>
    </div> <!-- row -->
</div> <!-- container -->
</body>
</html>
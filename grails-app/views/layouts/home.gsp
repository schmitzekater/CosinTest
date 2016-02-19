<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>COSIN &raquo; COmputerized Software INventory &nbsp;<g:layoutTitle default="Welcome"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--
        Lizenz: Kommerzieller Gebrauch gestattet, backlink erforderlich
        Autor: Icons8
        Website: www.icons8.com
    --%>
    <g:external uri="/assets/favicon.ico"/>
    <g:external uri="/assets/cosine_128.png" rel="apple-touch-icon-precomposed"/>
    <asset:stylesheet src="bootstrap-all.css"/>
    <asset:stylesheet src="font-awesome-all.css"/>
    <asset:stylesheet src="cosin.css"/>
    <asset:javascript src="jquery-2.1.3.js"/>
    <asset:javascript src="bootstrap-all.js"/>
    <g:layoutHead/>
</head>

<body>
<!-- Navigation Bar Top -->
<g:render template="/navigation/navMain"/>
<!-- Main Content  -->
    <g:layoutBody/>
<!-- Footer -->
<g:render template="/navigation/footer"/>
<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<asset:javascript src="fadeAndToggle.js"/>
<asset:javascript src="cosin_scroll.js"/>
</body>
</html>

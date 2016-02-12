<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>COSIN &raquo; COmputerized Software INventory<g:layoutTitle default="Welcome"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--
        Lizenz: Kommerziellen gebrauch gestattet, backlink erforderlich
        Autor: Icons8
        Website: www.icons8.com
    --%>
    <link rel="icon" type="image/x-icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}">
    <link rel="apple-touch-icon-precomposed" href="${createLinkTo(dir:'images',file:'cosine_128.png')}">
    <%-- Metro Tile on Windows 8+ --%>
    <meta name="msapplication-TileColor" content="#9900ff" />
    <meta name="msapplication-TileImage" content="${createLinkTo(dir:'images',file:'cosine_128.png')}">
    <asset:stylesheet src="bootstrap-all.css"/>
    <asset:stylesheet src="font-awesome-all.css"/>
    <asset:stylesheet src="cosin.css"/>
    <asset:javascript src="jquery-2.1.3.js"/>
    <asset:javascript src="bootstrap-all.js"/>
    <g:layoutHead/>

</head>

<body>

<g:render template="/navigation/navMain"/>                                          <!-- Navigation Bar Top -->

    <g:layoutBody/>                                                             <!-- Main Content  -->
                                                                                    <!-- end container -->
<g:render template="/navigation/footer"/>
<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<asset:javascript src="fadeAndToggle.js"/>
<asset:javascript src="cosin_scroll.js"/>
</body>
</html>

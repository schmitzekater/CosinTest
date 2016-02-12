<%--
  Created by IntelliJ IDEA.
  User: alexander
  Date: 22.12.2015
  Time: 20:16
--%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>COSIN &raquo; COmputerized Software INventory - Configuration<g:layoutTitle default="Welcome"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}">
    <asset:javascript src="jquery-2.1.3.js"/>
    <asset:javascript src="bootstrap-all.js"/>
    <asset:stylesheet src="bootstrap-all.css"/>
    <asset:stylesheet src="font-awesome-all.css"/>
    <asset:javascript src="clearInputs.js"/>
    <g:layoutHead/>
</head>

<body onscroll="fadeMessages()">
<g:render template="/navigation/navMain"/>                                          <!-- Navigation Bar Top -->
<div class="container"><!-- Container for all content -->
    <div class="well-sm">
        <g:render
                template="/layouts/messagesTop"/>                                  <!-- Top of page for messages / errors -->
    </div>

    <div class="row"><!-- First Row -->
        <div class="col-md-2 col-lg-2">
            <g:render template="/config/configNavLeft"/>                                  <!-- Sidebar Left  -->
            <g:render template="/navigation/navRight"/>
        </div>

        <div class="col-md-10 col-lg-10">
            <g:layoutBody/>                                                             <!-- Main Content  -->
        </div>
        %{--<div class="col-md-2">
                                            <!-- Sidebar Right -->
        </div> <!--col-md-2 -->--}%
    </div>                                                                          <!-- end row -->
</div>                                                                              <!-- end container -->
<g:render template="/navigation/footer"/>
</body>
</html>

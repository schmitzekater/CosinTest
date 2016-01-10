
<html>
<head>
    <meta name="layout" content="home"/>
    <title>Welcome to Grails</title>

</head>
<body role="document">
<div class="container"><!-- Container for all content -->
    <div class="well-sm">
        <g:render
                template="/layouts/messagesTop"/>                                  <!-- Top of page for messages / errors -->
    </div>

    <div class="row"><!-- First Row -->
        <div class="col-md-2">

        </div>
        <div id="error" class="col-md-8" role="home">

            <div id="panel error-panel">
                <h1>403</h1>
                <p>Access denied.</p>

            </div>
        </div>
        <div class="col-md-2">
            <g:render template="/navigation/navRight"/>
        </div>
    </div>                                                                          <!-- end row -->
</div>

</body>
</html>


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
        <g:render template="/navigation/navRight"/>

        </div>
    <div id="home" class="col-md-10" role="home">

        <div id="page-body" role="home">
            <h1>Welcome to Grails</h1>
            <p>Congratulations, you have successfully started your first Grails application! At the moment
               this is the default page, feel free to modify it to either redirect to a controller or display whatever
               content you may choose. Below is a list of controllers that are currently deployed in this application,
               click on each to execute its default action:</p>


        </div>
        </div>
    </div>                                                                          <!-- end row -->
</div>

    </body>
</html>

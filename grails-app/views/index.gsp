
<html>
    <head>
        <meta name="layout" content="home"/>
        <title><g:message code="index.welcome.message"/></title>

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
            <h1><g:message code="index.welcome.message"/></h1>

            <g:if test="${session.language=='en'}">
                <p>Welcome to the <f>CO</f>mputerized <f>S</f>ystem <f>IN</f>ventory.</p>
                <g:render template="/common/en/index"/>
               ${session.language}
            </g:if>
                <g:if test="${session.language=='de'}">
                    Und nun das Ganze auf Deutsch!! Trulla!!
                </g:if>
        </div>
        </div>
    </div>                                                                          <!-- end row -->
</div>

    </body>
</html>

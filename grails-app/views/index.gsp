
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
            <div id="intro">
                <h1 class="content-expand">Application Status</h1>
                <ul class="expand-content">
                    <li>Environment: ${grails.util.Environment.current.name}</li>
                    <li>App profile: ${grailsApplication.config.grails?.profile}</li>
                    <li>App version: <g:meta name="info.app.version"/></li>
                    <li>Grails version: <g:meta name="info.app.grailsVersion"/></li>
                    <li>Groovy version: ${GroovySystem.getVersion()}</li>
                    <li>JVM version: ${System.getProperty('java.version')}</li>
                    <li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
                </ul>
                <h1 class="content-expand">Artefacts</h1>
                <ul class="expand-content">
                    <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                    <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                    <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                    <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
                </ul>

            </div>
        </div>
    <div id="home" class="col-md-6" role="home">

        <div id="page-body" role="home">
            <h1>Welcome to Grails</h1>
            <p>Congratulations, you have successfully started your first Grails application! At the moment
               this is the default page, feel free to modify it to either redirect to a controller or display whatever
               content you may choose. Below is a list of controllers that are currently deployed in this application,
               click on each to execute its default action:</p>

            <div id="controller-list" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                    </g:each>
                </ul>
            </div>
        </div>
        </div>
        <div class="col-md-4">
            <g:render template="/navigation/navRight"/>
            <h1 class="content-expand">Installed Plugins</h1>
            <ul class="expand-content">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li>${plugin.name} - ${plugin.version}</li>
                </g:each>
            </ul>
        </div>
    </div>                                                                          <!-- end row -->
</div>

    </body>
</html>

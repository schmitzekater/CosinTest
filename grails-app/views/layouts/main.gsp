<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>COSIN &raquo COmputerized Software INventory<g:layoutTitle default="Welcome"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%-- TODO
      Individuelle Scripts auswählen, damit nicht alle aufschlagen!!! --%>
        <asset:javascript src="bootstrap-all.js"/>
        <asset:stylesheet src="bootstrap-all.css"/>
        <asset:stylesheet src="font-awesome-all.css"/>
        <g:layoutHead/>
    </head>

<body role="document">
<!-- <div id="grailsLogo" role="banner"><a href="http://grails.org"><asset:image src="grails_logo.png"
                                                                                 alt="Grails"/></a></div> -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
        <g:layoutBody/>
<div class="footer" role="contentinfo">
    <div class="well">
        <div class="row">
            <div class="col-md-2">

            </div>

            <div class="col-md-1">
                Link 1
            </div>

            <div class="col-md-1">
                Link 2
            </div>

            <div class="col-md-1">
                Link 3
            </div>

            <div class="col-md-1">
                Link 4
            </div>

            <div class="col-md-4" align="right">
                App version: <g:meta name="info.app.version"/> Powered by Grails <g:meta
                    name="info.app.grailsVersion"/></>
        </div>

        <div class="col-md-2">
        </div>
    </div>
</div>
        <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
    </body>
</html>

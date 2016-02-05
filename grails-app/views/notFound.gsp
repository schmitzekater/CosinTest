<!doctype html>
<html>
    <head>
        <title>Page Not Found</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
    <div align="center">
        %{--       <h1><span class="label label-default"><span class="glyphicon glyphicon-exclamation-sign"></span><g:message code="error.404"/></span></h1>--}%
        <g:img file="page404.png"/> <br/>


        <h1><span class="glyphicon glyphicon-arrow-left" aria-hidden="true" onclick="window.history.back()"
                  title="${message(code: 'default.back.label', default: 'Back')}"></span>
            &nbsp;<g:message code="default.back.label"/>
            &nbsp;
            <g:message code="default.home.label"/>
            <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"
                  title="${message(code: 'default.home.label', default: 'Home')}">

            </span>
        </h1>
    </div>
    </body>
</html>

<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>COSIN &raquo COmputerized Software INventory<g:layoutTitle default="Welcome"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%-- TODO
      Individuelle Scripts auswählen, damit nicht alle aufschlagen!!! --%>
        <asset:javascript src="jquery-2.1.3.js"/>
        <asset:javascript src="bootstrap-all.js"/>
        <asset:stylesheet src="bootstrap-all.css"/>
        <asset:stylesheet src="font-awesome-all.css"/>
        <g:layoutHead/>
    </head>

<body>
<g:if test="${controllerName}!=null">
    <g:set var="entityName" value="${controllerName.capitalize()}"/>
    <g:set var="action" value="${message(code: 'default' + actionName + 'label', default: actionName.capitalize())}"/>
</g:if>
<g:render template="/navigation/navMain"/>                                          <!-- Navigation Bar Top -->
<div class="container"><!-- Container for all content -->
    <div class="well-sm">
        <g:render
                template="/layouts/messagesTop"/>                                  <!-- Top of page for messages / errors -->
    </div>

    <div class="row"><!-- First Row -->
        <div class="col-md-2">
            <g:render template="/navigation/navLeft"/>                                  <!-- Sidebar Left  -->
        </div>
        <div class="col-md-8">
            <g:layoutBody/>                                                             <!-- Main Content  -->
        </div>
        <div class="col-md-2">
             <g:render template="/navigation/navRight"/>                                 <!-- Sidebar Right -->
        </div> <!--col-md-4 -->
    </div>                                                                          <!-- end row -->
</div>                                                                              <!-- end container -->
<g:render template="/navigation/footer"/>
        <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
    <asset:javascript src="fadeAndToggle.js"/>
    </body>
</html>

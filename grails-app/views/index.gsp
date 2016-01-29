<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="de.schmitzekater.*" %>
<html>
    <head>
        <meta name="layout" content="home"/>
        <title><g:message code="index.welcome.message"/></title>
        <g:if test="${!session.language}">
            <g:set var="${session.language='de'}"/>
        </g:if>
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
            <hr/>
            <g:if test="${session.language=='en'}">
                <g:render template="/common/en/index"/>
            </g:if>
            <g:if test="${session.language=='de'}">
                <g:render template="/common/de/index"/>
            </g:if>
                <p>Status</p>
                <div class="btn-toolbar">
                    <div class="btn-group btn-group-lg" role="group">
                        <button class="btn-info" type="button">
                            <g:message code="system.label">&nbsp</g:message><span class="badge">&nbsp${System.count()}</span>
                        </button>
                        <button class="btn-success" type="button">
                            <g:message code="unit.label">&nbsp</g:message><span class="badge">&nbsp${Unit.count()}</span>
                        </button>
                        <button class="btn-primary" type="button">
                            <g:message code="module.label">&nbsp</g:message><span class="badge">&nbsp${Module.count()}</span>
                        </button>
                        <button class="btn-warning" type="button">
                            <g:message code="software.label">&nbsp</g:message><span class="badge">&nbsp${Software.count()}</span>
                        </button>
                    </div>
                </div>
                <hr/>
                <div class="btn-toolbar">
                    <div class="btn-group btn-group-lg" role="group">
                        <button class="btn-info" type="button">
                            <g:message code="computer.label">&nbsp</g:message><span class="badge">&nbsp${Computer.count()}</span>
                        </button>
                        <button class="btn-success" type="button">
                            <g:message code="vendor.label">&nbsp</g:message><span class="badge">&nbsp${Vendor.count()}</span>
                        </button>
                        <button class="btn-primary" type="button">
                            <g:message code="person.label">&nbsp</g:message><span class="badge">&nbsp${Person.count()}</span>
                        </button>
                        <button class="btn-warning" type="button">
                            <g:message code="user.label">&nbsp</g:message><span class="badge">&nbsp${User.count()}</span>
                        </button>
                    </div>
                </div>
        </div>
        </div>
    </div>                                                                          <!-- end row -->
</div>

    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="de.schmitzekater.*" %>
<html>
<head>
    <meta name="layout" content="home"/>
    <title><g:message code="index.welcome.message"/></title>
    <g:if test="${!session.language}">
        <g:set var="${session.language = 'de'}"/>
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
            <div class="row-fluid">
                <div class="col-lg-8 col-md-8">
                    <h1 id="top"><a name="#top"><g:message code="index.welcome.message"/></a></h1>
                    <g:if test="${session.language == 'de'}">
                        <g:render template="/common/de/index"/>
                    </g:if>
                    <g:if test="${session.language == 'en'}">
                        <g:render template="/common/en/index"/>
                    </g:if>
                    <g:else>
                    <%-- Fallback --%>
                        <g:render template="/common/en/index"/>
                    </g:else>
                </div>

                <div class="col-lg-4 col-md-4 sidebar-outer" align="center">
                    <div class="sidebar">
                        <div class="well"><a><h2 id="systemStatus"><g:message code="system.status"/></h2></a>

                            <div class="row-fluid">
                                <div class="btn-group btn-group-vertical" role=group
                                     aria-label="Justified button group">
                                    <div class=btn-group role=group>
                                        <g:link controller="system" class="btn btn-primary"><g:message
                                                code="system.label"/>&nbsp;<span
                                                class="badge">${System.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="unit" class="btn btn-primary"><g:message
                                                code="unit.label"/>&nbsp;<span
                                                class="badge">${Unit.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="module" class="btn btn-primary"><g:message
                                                code="module.label"/>&nbsp;<span
                                                class="badge">${Module.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="software" class="btn btn-primary"><g:message
                                                code="software.label"/>&nbsp;<span
                                                class="badge">${Software.count()}</span></g:link>
                                    </div>
                                    %{-- </div>
                                      <hr/>
                                         <div class="btn-group btn-group-justified" role=group aria-label="Justified button group">--}%
                                    <div class=btn-group role=group>
                                        <g:link controller="computer" class="btn btn-primary"><g:message
                                                code="computer.label"/>&nbsp;<span
                                                class="badge">${Computer.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="vendor" class="btn btn-primary"><g:message
                                                code="vendor.label"/>&nbsp;<span
                                                class="badge">${Vendor.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="person" class="btn btn-primary"><g:message
                                                code="person.label"/>&nbsp;<span
                                                class="badge">${Person.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="user" class="btn btn-primary"><g:message
                                                code="user.label"/>&nbsp;<span
                                                class="badge">${User.count()}</span></g:link>
                                    </div>
                                    %{--  </div>
                                      <hr/>
                                      <div class="btn-group btn-group-vertical" role=group aria-label="Justified button group">--}%
                                    <div class=btn-group role=group>
                                        <g:link controller="auditLogEvent" class="btn btn-info"><g:message
                                                code="auditTrail.label"/>&nbsp;<span
                                                class="badge">${AuditLogEvent.count()}</span></g:link>
                                    </div>

                                    <div class=btn-group role=group>
                                        <button type="button" class="btn btn-info" style="float: right;"><g:message
                                                code="qualification.list.label"/>&nbsp;<span
                                                class="badge">${Qualification.count()}</span></button>
                                    </div>

                                    <div class=btn-group role=group>
                                        <g:link controller="config" class="btn btn-info"><g:message
                                                code="default.config.label"/></g:link>
                                    </div>
                                </div>
                            </div>

                            <div class="well">
                                <g:img file="cosine_64.png"/><br/>
                            </div>
                            <span class="glyphicon glyphicon-copyright-mark"></span>&nbsp;
                            <a href="mailto:alexanderschmitz76@gmail.com">schmitzekater 2016</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>                                                                          <!-- end row -->
    </div>
</body>
</html>

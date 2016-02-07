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

    <div class="row" ><!-- First Row -->

        <div class="col-md-2">
            <g:render template="/navigation/navRight"/>

        </div>

        <div id="home" class="col-md-10" role="home">

                <div class="row-fluid">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"> <g:img file="cosine_64.png"/></div>
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8"><h1 id="top"> <a name="#top"><g:message code="index.welcome.message"/></a></h1></div>
                </div>
                <hr/>
                <g:if test="${session.language == 'en'}">
                    <g:render template="/common/en/index"/>
                </g:if>
                <g:if test="${session.language == 'de'}">
                    <g:render template="/common/de/index"/>
                </g:if>
                <p><h2 id="systemStatus"><g:message code="system.status"/></h2> </p>
                <div class="row-fluid">

                <hr/>
                <div class="btn-group btn-group-vertical" role=group aria-label="Justified button group">
                    <div class=btn-group role=group>
                        <g:link controller="system" class="btn btn-primary"> <g:message code="system.label"/><span
                                class="badge">&nbsp;${System.count()}</span></g:link>
                    </div>
                    <div class=btn-group role=group>
                        <g:link controller="unit" class="btn btn-primary"> <g:message code="unit.label"/><span
                                class="badge">&nbsp;${Unit.count()}</span></g:link>
                    </div>
                    <div class=btn-group role=group>
                        <g:link controller="module" class="btn btn-primary"> <g:message code="module.label"/><span
                                class="badge">&nbsp;${Module.count()}</span></g:link>
                    </div>
                    <div class=btn-group role=group>
                        <g:link controller="software" class="btn btn-primary"> <g:message code="software.label"/><span
                                class="badge">&nbsp;${Software.count()}</span></g:link>
                    </div>
               %{-- </div>
                 <hr/>
                    <div class="btn-group btn-group-justified" role=group aria-label="Justified button group">--}%
                        <div class=btn-group role=group>
                            <g:link controller="computer" class="btn btn-primary"> <g:message code="computer.label"/><span
                                    class="badge">&nbsp;${Computer.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="vendor" class="btn btn-primary"><g:message code="vendor.label">&nbsp</g:message><span
                                    class="badge">&nbsp;${Vendor.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="person"  class="btn btn-primary"> <g:message code="person.label">&nbsp</g:message><span
                                    class="badge">&nbsp;${Person.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="user"class="btn btn-primary"><g:message code="user.label"/><span
                                    class="badge">&nbsp;${User.count()}</span></g:link>
                        </div>
                  %{--  </div>
                    <hr/>
                    <div class="btn-group btn-group-vertical" role=group aria-label="Justified button group">--}%
                        <div class=btn-group role=group>
                            <g:link controller="auditLogEvent" class="btn btn-info"> <g:message code="auditTrail.label"/><span
                                    class="badge">&nbsp;${AuditLogEvent.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <button type="button"  class="btn btn-info"> <g:message code="qualification.list.label">&nbsp</g:message><span
                                    class="badge">&nbsp;${Qualification.count()}</span></input>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="config" class="btn btn-info"><g:message code="default.config.label"/></g:link>
                        </div>
                    </div>
                    <div class="btn-group btn-group-vertical" role=group aria-label="Justified button group">
                        <div class=btn-group role=group>
                            <g:link controller="system" class="btn btn-primary"> <g:message code="system.label"/><span
                                    class="badge">&nbsp;${System.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="unit" class="btn btn-primary"> <g:message code="unit.label"/><span
                                    class="badge">&nbsp;${Unit.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="module" class="btn btn-primary"> <g:message code="module.label"/><span
                                    class="badge">&nbsp;${Module.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="software" class="btn btn-primary"> <g:message code="software.label"/><span
                                    class="badge">&nbsp;${Software.count()}</span></g:link>
                        </div>
                        %{-- </div>
                          <hr/>
                             <div class="btn-group btn-group-justified" role=group aria-label="Justified button group">--}%
                        <div class=btn-group role=group>
                            <g:link controller="computer" class="btn btn-primary"> <g:message code="computer.label"/><span
                                    class="badge">&nbsp;${Computer.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="vendor" class="btn btn-primary"><g:message code="vendor.label">&nbsp</g:message><span
                                    class="badge">&nbsp;${Vendor.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="person"  class="btn btn-primary"> <g:message code="person.label">&nbsp</g:message><span
                                    class="badge">&nbsp;${Person.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="user"class="btn btn-primary"><g:message code="user.label"/><span
                                    class="badge">&nbsp;${User.count()}</span></g:link>
                        </div>
                        %{--  </div>
                          <hr/>
                          <div class="btn-group btn-group-vertical" role=group aria-label="Justified button group">--}%
                        <div class=btn-group role=group>
                            <g:link controller="auditLogEvent" class="btn btn-info"> <g:message code="auditTrail.label"/><span
                                    class="badge">&nbsp;${AuditLogEvent.count()}</span></g:link>
                        </div>
                        <div class=btn-group role=group>
                            <button type="button"  class="btn btn-info"> <g:message code="qualification.list.label">&nbsp</g:message><span
                                    class="badge">&nbsp;${Qualification.count()}</span></input>
                        </div>
                        <div class=btn-group role=group>
                            <g:link controller="config" class="btn btn-info"><g:message code="default.config.label"/></g:link>
                        </div>
                    </div>
                    <hr/>
                </div>
        </div>
    </div>                                                                          <!-- end row -->
</div>
</body>
</html>

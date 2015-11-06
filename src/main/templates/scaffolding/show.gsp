<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="nav" role="navigation">
                <ul class="list-group">
                    <li class="list-group-item"><g:link class="list" action="list"><g:message code="default.list.label"
                                                                                              args="[entityName]"/></g:link></li>
                    <li class="list-group-item"><g:link class="create" action="create"><g:message
                            code="default.new.label" args="[entityName]"/></g:link></li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">
                        <a class="home" href="\${createLink(uri: '/')}">
                            <g:message code="default.home.label"/>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div id="show-${propertyName}" class="col-md-6" role="main">
            <h1><g:message code="default.show.label" args="[entityName]"/></h1>
            <g:if test="\${flash.message}">
                <<div class="alert alert-info" role="alert">\${flash.message}</div>
            </g:if>
            <f:display bean="${propertyName}"/>
            <g:form resource="\${this.${propertyName}}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="\${this.${propertyName}}"><g:message
                            code="default.button.edit.label" default="Edit"/></g:link>
                    <input class="delete" type="submit"
                           value="\${message(code: 'default.button.delete.label', default: 'Delete')}"
                           onclick="return confirm('\${message(code: '
                           default.button.delete.confirm.message
                           ', default: '
                           Are
                           you
                           sure ? ')}'
                           )
                           ;"/>
                </fieldset>
            </g:form>
        </div>

        <div class="col-md-4">
            <h2><g:message code="default.right.sidebar"/></h2>

        </div>
    </div>
</div>
</body>
</html>

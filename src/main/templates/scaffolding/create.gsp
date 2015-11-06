<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div class="row">
    <div class="col-md-2">
        <a href="#create-${propertyName}" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                                default="Skip to content&hellip;"/></a>

        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="\${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label"
                                                                   args="[entityName]"/></g:link></li>
            </ul>
        </div>
    </div>

    <div id="create-${propertyName}" class="col-md-6" role="main">
        <h1><g:message code="default.create.label" args="[entityName]"/></h1>
        <g:if test="\${flash.message}">
            <div class="message" role="status">\${flash.message}</div>
        </g:if>
        <g:hasErrors bean="\${this.${propertyName}}">
            <ul class="errors" role="alert">
                <g:eachError bean="\${this.${propertyName}}" var="error">
                    <li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message
                            error="\${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
        <fieldset>
            <g:form action="save" class="form">
                <fieldset>
                    <f:all bean="${propertyName}"/>
                </fieldset>

                <div class="form-actions">
                    <g:submitButton name="create" class="btn btn-primary"
                                    value="\${message(code: 'default.button.create.label', default: 'Create')}"/>
                </div>
            </g:form>
        </fieldset>
    </div>

    <div class="col-md-4">
        <h2><g:message code="default.right.sidebar"/></h2>

    </div>
</div>
</body>
</html>

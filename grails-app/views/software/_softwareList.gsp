<%@ page import="de.schmitzekater.User" %>

<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td>
        <td><g:message code="software.softwareName.label"/></td>
        <td><g:message code="software.softwareVersion.label"/> </td>
        <td><g:message code="vendor.vendorName.label"/></td>
        <td><g:message code="system.systemName.label"/></td>
    </tr>
    </thead>
    <tbody>
    <g:each var="software" in="${model}">
        <tr>
            <td><g:link action="show" id="${software.id}">${software.id}</g:link></td>
            %{-- TODO: Umstellen auf Felder!! Dabei auf missing values achten!--}%
            <td>${software.softwareName}</td>
            <td>${software.softwareVersion}</td>
            <td><g:link controller="vendor" id="${software.softwareVendor.id}" action="detail">${software.softwareVendor.getDisplayString()}</g:link></td>
            <td><g:link controller="system" id="${software.system?.id}" action="detail"> ${system?.systemName}</g:link></td>
            <g:render template="/layouts/editInfoButtons" model="[model: software]"/>
        </tr>
    </g:each>
    </tbody>
</table>
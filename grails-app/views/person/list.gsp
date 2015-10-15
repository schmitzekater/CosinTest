<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 10.10.2015
  Time: 14:09
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Personenliste</title>
    <meta name="layout" content="main"/>
    <%-- TODO
        Individuelle Scripts auswählen, damit nicht alle aufschlagen!!! --%>
    <asset:javascript src="bootstrap-all.js"/>
    <asset:stylesheet src="bootstrap-all.css"/>
    <asset:stylesheet src="font-awesome-all.css"/>
</head>

<body role="document">
<div class="page-header">
    <span class="label label-danger">Liste der Personen</span>

    <p>Gefunden wurden ${numPersons} Personen.</p>
    <table class="table">
        <thead>
        <tr>
            <td>Id</td><td>Nachname</td><td>Vorname</td>^<td>UserId</td>
        </tr>
        </thead>
        <tbody>
        <g:each var="person" in="${persons}">
            <tr>
                <td>${person.id}</td>
                <td>${person.lastName}</td>
                <td>${person.firstName}</td>
                <td>
                    <g:if test="${person.user != null}">
                    <g.createLink controller="User" action="show" id="${person.user.userId}" >${person.user.userId}</g>
                    </g:if>
                    <g:else>
                    --
                    </g:else>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
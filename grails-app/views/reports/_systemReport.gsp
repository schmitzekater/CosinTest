<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 03.02.2016
  Time: 19:32
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="de.schmitzekater.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title></title>
    <g:set var="date" value="${new Date()}"/>
    <style  type="text/css">
    @page {
        size: 210mm 297mm; // A4 format
    @bottom-center { content: element(footer);}
    @bottom-right {
        content: counter(page) "/" counter(pages);
    }
    @top-left { content: "Cosin Report ${system.getDisplayString()} <g:img dir='/images' file='cosine_64.png'/>"; }
        @top-right {content: ${date}}
    .make-grid(sm);
    }
    a {
        color: inherit; /* Normal colors for links too */
        text-decoration: inherit; /* no underline */
    }

    @media print {

    }

    div.break {
        page-break-after:always;
    }

    </style>
</head>

<body>

<div class="footer" id="footer"><g:formatDate date="${new Date()}" format="yyyy-MMM-dd"/>  Report created by <sec:loggedInUserInfo field="username"/> </div>
    <h1><g:message code="info.system"/> </h1>
    <h2>${system.getDisplayString()}</h2>
    <hr/>
<f:with bean="system">
    <f:display property="systemName"/>
    <f:display property="systemDepartment"/>
    <f:display property="systemOwner"/>
    <f:display property="processOwner"/>
    <f:display property="area"/>
    <f:display property="systemDataCategory"/>
    <f:display property="dataFlow"/>
</f:with>
<hr/>
<h3><g:message code="unit.list.label"/></h3>
<g:if test="${system.units.size()>0}">
    <g:render template="/unit/unitList" model="${[model: system.units]}"/>
</g:if>
<g:else>
    <g:message code="system.no.unit"/>
</g:else>
<hr/>
<%-- Get the software of the system --%>
<h3><g:message code="software.list.label"/></h3>
<g:if test="${system.usesSoftware.size()>0}">
    <g:render template="/software/softwareList" model="[model: system.usesSoftware]"/>
</g:if>
<g:else>
    <g:message code="system.no.software"/>
</g:else>
<hr/>
<%-- Get the computers of the system --%>
<h3><g:message code="computer.list.label"/></h3>
<g:if test="${system.computer.size()>0}">
    <g:render template="/computer/computerList" model="${[model: system.getComputer()]}"/>
</g:if>
<g:else>
    <g:message code="system.no.computer"/>
</g:else>
<div class="break"/>
<h2>Unit Details</h2>
<g:each var="unit" in="${system.units}">
    <f:with bean="${unit}">
        <f:display property="unitName"/>
        <f:display property="system"/>
    </f:with>
    <hr/>
    <h2>Modules of ${unit.unitName}</h2>
    <g:each var="module" in="${unit.modules}">
        <f:with bean="${module}">
            <f:display property="moduleName"/>
            <f:display property="moduleSerial"/>
            <f:display property="moduleModel"/>
            <f:display property="moduleFirmware"/>
            <f:display property="moduleVendor"/>
            <f:display property="moduleType"/>
            <f:display property="moduleConnection"/>
            <f:display property="unit"/>
            <g:if test="${module.needsCalibration==true}">
                <f:display property="needsCalibration" />
                <f:display property="lastCalibration"/>
                <f:display property="nextCalibration"/>
            </g:if>
            <f:display property="productiveDate"/>
            <g:if test="${module.retirementDate != null}">
                <f:display property="retirementDate"/>
            </g:if>
        </f:with>
        <br/>
    </g:each>
</g:each>
<div class="break"/>
<h2>Computer Details</h2>
<g:each var="computer" in="${system.getComputer()}">
    <f:with bean="${computer}">
        <f:display property="computerName"/>
        <f:display property="computerVendor"/>
        <f:display property="installedSoftware"/>
    </f:with>
    <br/>
</g:each>
</body>
</html>
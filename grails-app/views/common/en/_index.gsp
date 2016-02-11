<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 28.01.2016
  Time: 23:11
--%>
<html>
<body>
<div>
    <div>
        <p>
            Cosin is an application to handle Computerized System within the area of Pharmaceutics.
        </p>
        <p>
            To achieve this goal, a variety of Elements can be administered. The following objects can be handled.
        <ul class="list-group">
            <li class="list-group-item"><a href="#System">Systems</a></li>
            <li class="list-group-item"><a href="#Unit">Units</a></li>
            <li class="list-group-item"><a href="#Module">Modules</a></li>
            <li class="list-group-item"><a href="#Software">Software</a></li>
            <li class="list-group-item"><a href="#Computer">Computer</a></li>
            <li class="list-group-item"><a href="#Vendor">Vendors</a></li>
            <li class="list-group-item"><a href="#Qualification">Qualifications</a></li>
            <li class="list-group-item"><a href="#Configuration">Configuration</a></li>
        </ul>
    </p>
        <a name="System"><h2 id="System"><g:message code="system.label"/></h2></a>
        <p>
            Descritption for systems.
            We need a lot of info here!
            <cos:infoText>Example of an informational text.</cos:infoText>
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Unit"><h2 id="Unit"><g:message code="unit.label"/></h2></a>
        <p>
            Units are a collection of Modules building an entity. An unit can consist of one or more modules.
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Module"><h2 id="Module"><g:message code="module.label"/></h2></a>
        <p>
            A module is the smallest part of an unit. Each module can only be assigned to one Unit. A module cannot be assigned to a system without an unit.
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Software"><h2 id="Software"><g:message code="software.label"/></h2></a>
        <p>
            A software might be installed to one ore more computers. Each computer can have installations of multiple different softwares.
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Computer"><h2 id="Computer"><g:message code="computer.label"/> </h2></a>
        <p>
           Each Computer can have multiple roles within a system, and can have different roles in others system.
            <cos:successText>Successful message.</cos:successText>
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Vendor"><h2 id="Vendor"><g:message code="vendor.label"/></h2></a>
        <p>
           The class vendor serves as contact to the vendor for softwre or modules.
            <cos:errorText>This is an error message.</cos:errorText>
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Qualification"><h2 id="Qualification"><g:message code="qualification.label"/> </h2></a>
        <p>
            Each Qualification is of a specifici Qualification Type. Those types can be configured in the configuration.
            <cos:alertText>Bthe qualification type 'Calibration' must never be deleted. Otherwise the appointment for the
            next Calibration cannot be calculated anymore.!</cos:alertText>
        </p>
        <cos:linkTo anchor="#top" value="To top"/>
        <a name="Configuration"><h2 id="Configuration">Konfiguration</h2></a>
        <p>
            The following types can be configured within the application.
        <ul class="list-group">
            <li class="list-group-item">Data Category</li>
            <li class="list-group-item">Qualification Type</li>
            <li class="list-group-item">Module Type</li>
            <li class="list-group-item">Connection Type</li>
            <li class="list-group-item">Computer Role</li>
        </ul>
    </p>
        <cos:linkTo anchor="#top" value="To top"/>
    </div>
</div>
</body>
</html>

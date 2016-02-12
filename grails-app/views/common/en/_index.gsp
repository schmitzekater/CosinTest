<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 28.01.2016
  Time: 23:11
--%>
<div>
    <div>
        <div>
            Cosin is an application to handle Computerized System within the area of Pharmaceutics.
        </div>

        <div>
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
        </div>
        <a id="System"><h2><g:message code="system.label"/></h2></a>

        <div>
            Descritption for systems.
            We need a lot of info here!
            <cos:infoText>Example of an informational text.</cos:infoText>
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Unit"><h2><g:message code="unit.label"/></h2></a>

        <div>
            Units are a collection of Modules building an entity. An unit can consist of one or more modules.
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Module"><h2><g:message code="module.label"/></h2></a>

        <div>
            A module is the smallest part of an unit. Each module can only be assigned to one Unit. A module cannot be assigned to a system without an unit.
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Software"><h2><g:message code="software.label"/></h2></a>

        <div>
            A software might be installed to one ore more computers. Each computer can have installations of multiple different softwares.
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Computer"><h2><g:message code="computer.label"/></h2></a>

        <div>
           Each Computer can have multiple roles within a system, and can have different roles in others system.
            <cos:successText>Successful message.</cos:successText>
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Vendor"><h2><g:message code="vendor.label"/></h2></a>

        <div>
           The class vendor serves as contact to the vendor for softwre or modules.
            <cos:errorText>This is an error message.</cos:errorText>
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Qualification"><h2><g:message code="qualification.label"/></h2></a>

        <div>
            Each Qualification is of a specifici Qualification Type. Those types can be configured in the configuration.
            <cos:alertText>Bthe qualification type 'Calibration' must never be deleted. Otherwise the appointment for the
            next Calibration cannot be calculated anymore.!</cos:alertText>
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
        <a id="Configuration"><h2>Konfiguration</h2></a>

        <div>
            The following types can be configured within the application.
        <ul class="list-group">
            <li class="list-group-item">Data Category</li>
            <li class="list-group-item">Qualification Type</li>
            <li class="list-group-item">Module Type</li>
            <li class="list-group-item">Connection Type</li>
            <li class="list-group-item">Computer Role</li>
        </ul>
        </div>
        <cos:linkTo anchor="#top" value="To top"/>
    </div>
</div>

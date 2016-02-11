<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 28.01.2016
  Time: 23:11
--%>

<div>
    <p>
       Cosin ist eine Anwendung die die Verwaltung von Computergestützten Systemen im Umfeld der pharmazeutischen Industrie erleichtern soll.
    </p>
    <p>
        Dazu können eine Vielzahl verschiedener Elemente verwaltet werden. Dazu gehören die folgenden Klassen:
        <ul class="list-group">
            <li class="list-group-item"><a href="#System">Systeme</a></li>
            <li class="list-group-item"><a href="#Unit">Messplätze</a></li>
            <li class="list-group-item"><a href="#Module">Module</a></li>
            <li class="list-group-item"><a href="#Software">Software</a></li>
            <li class="list-group-item"><a href="#Computer">Computer</a></li>
            <li class="list-group-item"><a href="#Vendor">Hersteller</a></li>
            <li class="list-group-item"><a href="#Qualification">Qualifizierungen</a></li>
            <li class="list-group-item"><a href="#Configuration">Konfigurationen</a></li>
        </ul>
    </p>
    <a name="System"><h2 id="System"><g:message code="system.label"/></h2></a>
     <p>
        Systeme Beschreibung.
         Für Systeme brauche ich viel Info.
         <cos:infoText>Hier ist der Infotext</cos:infoText>
     </p>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a name="Unit"><h2 id="Unit"><g:message code="unit.label"/></h2></a>
     <p>
        Messplätze sind Zusammenstellungen von Modulen, die eine Einheit bilden. Ein Messplatz kann dabei aus nur einem, oder mehreren Modulen bestehen.
     </p>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a name="Module"><h2 id="Module"><g:message code="module.label"/></h2></a>
     <p>
        Ein Modul ist die kleinste Einheit eines Messplatzes. Ein Modul kann nur einem Messplatz zugeordnet werden. Ohne Messplatz kann ein Modul nicht einem System zugeordnet werden.
     </p>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a name="Software"><h2 id="Software"><g:message code="software.label"/></h2></a>
     <p>
        Eine Software ist eine Software, ist eine Software. Eine Software kann zu mehreren Systemen gehören, und ein System kann mehrere Software beinhalten.
         Eine Software kann auch auf mehreren computer installiert werden.
     </p>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a name="Computer"><h2 id="Computer"><g:message code="computer.label"/> </h2></a>
     <p>
        Ein Computer ist halt ein Computer. Dabei kann ein Computer verschiedene Rollen in einem oder auch in mehreren Systemen haben.
         Die Rollen können in der Konfiguration definiert werden.
         <cos:successText>Hier habe ich mal Erfolg gehabt.</cos:successText>
     </p>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a name="Vendor"><h2 id="Vendor"><g:message code="vendor.label"/></h2></a>
     <p>
        Ein Hersteller kann Adressdaten aufnehmen, und Hersteller für Software oder Module sein.
         Die Pflege der Hersteller kann Schwierigkeiten bei der Kontaktaufnahme minimieren.
         <cos:errorText>Fehler hier!!!</cos:errorText>
     </p>
    <cos:linkTo anchor="#top" value="Nach oben"/>
    <a name="Qualification"><h2 id="Qualification"><g:message code="qualification.label"/> </h2></a>
     <p>
        Eine Qualifizierung kann einen Qualifizierungstyp darstellen. Diese Typen können in der Konfiguration angepasst werden.
         <cos:alertText>Bitte niemals den Qualifizierungstyp "Kalibrierung" löschen!
            Dieser ist essentiell für die Kalibrierung von Modulen. Ohne Typ Kalibrierung wird die nächste Kalibirerung nicht berechnet!</cos:alertText>
     </p>
    <cos:linkTo anchor="#top" value="Nach oben"/>
     <a name="Configuration"><h2 id="Configuration">Konfiguration</h2></a>
    <p>
        Die folgenden Typen können in der Konfiguration angepasst werden:
        <ul class="list-group">
            <li class="list-group-item">Datenkategorie</li>
            <li class="list-group-item">Qualifizierungsart</li>
            <li class="list-group-item">Modultyp</li>
            <li class="list-group-item">Verbindungstypen</li>
            <li class="list-group-item">Computerrollen</li>
        </ul>
    </p>
<cos:linkTo anchor="#top" value="Nach oben"/>
</div>
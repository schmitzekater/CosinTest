<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 28.01.2016
  Time: 23:11
--%>

<div>
    <div>
       Cosin ist eine Anwendung die die Verwaltung von Computergestützten Systemen im Umfeld der pharmazeutischen Industrie erleichtern soll.
    </div>

    <div>
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
    </div>
    <a id="System"><h2><g:message code="system.label"/></h2></a>

    <div>
        Systeme Beschreibung.
         Für Systeme brauche ich viel Info.
         <cos:infoText>Hier ist der Infotext</cos:infoText>
    </div>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Unit"><h2><g:message code="unit.label"/></h2></a>

    <div>
        Messplätze sind Zusammenstellungen von Modulen, die eine Einheit bilden. Ein Messplatz kann dabei aus nur einem, oder mehreren Modulen bestehen.
    </div>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Module"><h2><g:message code="module.label"/></h2></a>

    <div>
        Ein Modul ist die kleinste Einheit eines Messplatzes. Ein Modul kann nur einem Messplatz zugeordnet werden. Ohne Messplatz kann ein Modul nicht einem System zugeordnet werden.
    </div>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Software"><h2><g:message code="software.label"/></h2></a>

    <div>
        Eine Software ist eine Software, ist eine Software. Eine Software kann zu mehreren Systemen gehören, und ein System kann mehrere Software beinhalten.
         Eine Software kann auch auf mehreren computer installiert werden.
    </div>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Computer"><h2><g:message code="computer.label"/></h2></a>

    <div>
        Ein Computer ist halt ein Computer. Dabei kann ein Computer verschiedene Rollen in einem oder auch in mehreren Systemen haben.
         Die Rollen können in der Konfiguration definiert werden.
         <cos:successText>Hier habe ich mal Erfolg gehabt.</cos:successText>
    </div>
<cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Vendor"><h2><g:message code="vendor.label"/></h2></a>

    <div>
        Ein Hersteller kann Adressdaten aufnehmen, und Hersteller für Software oder Module sein.
         Die Pflege der Hersteller kann Schwierigkeiten bei der Kontaktaufnahme minimieren.
         <cos:errorText>Fehler hier!!!</cos:errorText>
    </div>
    <cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Qualification"><h2><g:message code="qualification.label"/></h2></a>

    <div>
        Eine Qualifizierung kann einen Qualifizierungstyp darstellen. Diese Typen können in der Konfiguration angepasst werden.
         <cos:alertText>Bitte niemals den Qualifizierungstyp "Kalibrierung" löschen!
            Dieser ist essentiell für die Kalibrierung von Modulen. Ohne Typ Kalibrierung wird die nächste Kalibirerung nicht berechnet!</cos:alertText>
    </div>
    <cos:linkTo anchor="#top" value="Nach oben"/>
    <a id="Configuration"><h2>Konfiguration</h2></a>

    <div>
        Die folgenden Typen können in der Konfiguration angepasst werden:
        <ul class="list-group">
            <li class="list-group-item">Datenkategorie</li>
            <li class="list-group-item">Qualifizierungsart</li>
            <li class="list-group-item">Modultyp</li>
            <li class="list-group-item">Verbindungstypen</li>
            <li class="list-group-item">Computerrollen</li>
        </ul>
    </div>
<cos:linkTo anchor="#top" value="Nach oben"/>
</div>
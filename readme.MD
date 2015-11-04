
# Cosin - COmputerized System INventory
==
Cosin ist eine Anwendung um GxP-Systeme zu verwalten.
Cosin entsteht im Rahmen der Masterarbeit von Alexander Schmitz an der [Beuth Hochschule für Technik, Berlin](http://www.beuth-hochschule.de/).

## Beschreibung
--
Dieses Projekt basiert auf [Grails][Grails] mit der Programmiersprache [Groovy][Groovy].
 
[Grails]: http://grails.org/
[Groovy]: http://groovy-lang.org/
[plugins]: http://grails.org/plugins/

## Vorbereitungen
--
Um das Projekt auf einem anderen PC laufen zu lassen, folgen Sie bitte den folgenden Anweisungen:

1. Download und Installation eines JDK, im Projekt verwendet ist die Version JDK 8 Update 60, zum Beispiel von [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Setzen einer Variable `JAVA_HOME` in den erweiterten Systemeinstellungen mit der Pfadangabe der JDK-Installation
3. Ergänzen von `%JAVA_HOME%\bin` in der `PATH`-Variable
4. Download Grails, im Projekt verwendet ist die Version 3.0.8, von [Grails.org](https://grails.org/download.html)
5. Entpacken von Grails (z.B. `C:\dev\grails\grails3.0.8`)
6. Setzen einer Variable `GRAILS_HOME` in den erweiterten Systemeinstellungen mit der Pfadangabe des entpackten Grails-Ordners
7. Ergänzen von `%GRAILS_HOME%\bin` in der `PATH`-Variable
8. Öffnen der Kommandozeile und Eintippen von `grails -version`sollte die aktuelle Grails-, Groovy- und Java-Version anzeigen
9. Nun können Grails-Projekte erstellt werden, zum Beispiel per:

```
	grails create-app sampleapp
	cd sampleapp
	grails run-app
```

## Repository clonen
---
Das Projekt lässt sich am einfachsten per [GIT](https://git-scm.com/downloads) clonen
Dazu die folgenden Zeilen in der Kommandozeile eingeben:

    git clone https://github.com/schmitzekater/cosintest.git
    cd cosintest
    grails run-app
    
## License
TBD

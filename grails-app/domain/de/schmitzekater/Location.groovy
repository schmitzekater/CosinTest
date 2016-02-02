package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to handle Locations of different other Domain Classes
 * TODO: Implement Views and handling of Locations
 * TODO: Maybe different classes for Buildings
 */
class Location {
    String locationBuilding
    String locationBuildingAbbreviation
    String locationLevel
    String locationRoom

    static belongsTo = [unit: Unit, computer: Computer]
    static constraints = {
        locationBuilding blank: false
        locationBuildingAbbreviation blank: false
        locationLevel blank: false, maxSize: 6
        locationRoom blank: false
        unit nullable: true
        computer nullable: true
    }

    String toString() {
        getDisplayString()
    }

    String getDisplayString(){
        // Example: 'N-03-3.20'
        locationBuildingAbbreviation+'-'+locationLevel+'-'+locationRoom
    }
}

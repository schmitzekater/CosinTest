package de.schmitzekater

class Location {
    String locationBuilding
    String locationLevel
    String locationRoom

    static belongsTo = [unit: Unit, computer: Computer]
    static constraints = {
        locationBuilding blank: false
        locationLevel blank: false, maxSize: 6
        locationRoom blank: false
        unit nullable: true
        computer nullable: true
    }
}

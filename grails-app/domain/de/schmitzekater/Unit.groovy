package de.schmitzekater

class Unit {
    String unitName

    static auditable = true
    static hasMany = [modules: Module]
    static hasOne = [location: Location]
    static belongsTo = [system: System]
    static constraints = {
        //computer nullable: true
        modules nullable: true
        location nullable: true
        system nullable: true
        unitName blank: false, maxSize: 50, unique: true
    }

    String getDisplayString() {
        return unitName
    }

    String toString() {
        getDisplayString()
    }

}

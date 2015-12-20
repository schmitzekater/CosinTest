package de.schmitzekater

class Unit {
    String unitName

    static hasMany = [modules: Module]
    static hasOne = [location: Location]
    static belongsTo = [system: System]
    static constraints = {
        //computer nullable: true
        modules nullable: true
        location nullable: true
        unitName blank: false, maxSize: 50
    }

    String getDisplayString() {
        return unitName
    }

    String toString() {
        getDisplayString()
    }

}

package de.schmitzekater

class Unit {
    String unitName

    static hasMany = [modules: Module]
    static hasOne = [computer: Computer, location: Location, unitArea: GxpArea]
    static belongsTo = [system: System]
    static constraints = {
        computer nullable: true
        modules nullable: true
        unitArea nullable: false
        location nullable: true
        unitName blank: false, maxSize: 50
    }
}

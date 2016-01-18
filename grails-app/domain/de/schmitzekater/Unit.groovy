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

    static List<Unit> getAvailableUnits() {
        /*  Get the list of Units, that are not bound to a system
         */
        createCriteria().list() {
            sqlRestriction('not exists (select 1 from Unit u inner join System s on u.system_id = s.id where u.id = this_.id) ')
        }
    }

}

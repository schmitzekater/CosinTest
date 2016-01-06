package de.schmitzekater

import java.sql.Blob

class System implements Serializable{
    private static final long serialVersionUID = 1
    String systemName
    boolean isActive
    Blob dataFlow
    Date retirementDate // TODO Set it manually
    String area


    static belongsTo = [systemDepartment: Department, systemOwner: Person, processOwner: Person]
    static hasMany = [units: Unit, software: Software, systemOwner: Person, processOwner: Person]
    static hasOne = [systemDataCategory: DataCategory]

    static auditable = true

    static constraints = {
        systemName blank: false, maxSize: 50
        dataFlow nullable: true, display: false
        systemDepartment nullable: true
        systemOwner nullable: true
        processOwner nullable: true
        units nullable: true
        systemDataCategory nullable: true
        area nullable: false, inList: ["GCP", "GLP", "GMP"]
        software nullable: true
        retirementDate nullable: true, display: false
    }

    String getDisplayString() {
        return systemName
    }

    String toString() {
        getDisplayString()
    }

    /**
     * Angelehnt an Spring security Plugin (Verbindung System / Computer / Computerrolle)
     */
    Set<Computer> getComputer(){
        SystemRole.findAllBySystem(this)*.computer
    }
    Set<SystemRole> getSystemRole(){
        SystemRole.findAllBySystem(this)
    }
}

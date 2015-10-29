package de.schmitzekater

import java.sql.Blob

class System {
    String systemName
    boolean isActive
    Blob dataFlow
    Date retirementDate // TODO Set it manually
    //enum area   {GCP, GLP, GMP}
    String area


    static belongsTo = [systemDepartment: Department, systemOwner: Person, processOwner: Person]
    static hasMany = [units: Unit, software: Software, servers: Computer, clients: Computer, systemOwner: Person, processOwner: Person]
    static hasOne = [systemDataCategory: DataCategory]

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
        servers nullable: true
        clients nullable: true
        retirementDate nullable: true, display: false

    }

    String getDisplayString() {
        return systemName
    }

}

package de.schmitzekater

import java.sql.Blob

class System {
    String systemName
    boolean isActive
    Blob dataFlow
    Date retirementDate // TODO Set it manually
    String area


    static belongsTo = [systemDepartment: Department, systemOwner: Person, processOwner: Person]
    static hasMany = [units: Unit, software: Software, servers: Server, clients: Client, systemOwner: Person, processOwner: Person]
    static hasOne = [systemDataCategory: DataCategory]
    /*static mapping = {
        servers joinTable: [name: 'mm_system_computer', key: 'mm_system_id']
        clients joinTable: [name: 'mm_system_computer', key: 'mm_system_id']
    }*/
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
        servers nullable: true
        clients nullable: true
        retirementDate nullable: true, display: false

    }

    String getDisplayString() {
        return systemName
    }

    String toString() {
        getDisplayString()
    }

}

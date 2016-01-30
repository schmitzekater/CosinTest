package de.schmitzekater

class Software extends QualifiableObject{
    String softwareName
    String softwareVersion
    String softwareIqOq
    Date   lastQualification

    static auditable = [ignore:['version','lastUpdated','qualifications']]
    static hasOne = [softwareVendor: Vendor]
    static hasMany = [computer: Computer, system: System]
    static belongsTo = [System, Computer]

    static constraints = {
        softwareName blank: false, maxSize: 50
        softwareVersion blank: false
        softwareIqOq blank: true, nullable: true
        softwareVendor nullable: true
        system nullable: true
        computer nullable: true
        lastQualification nullable: true
    }
    def getAuditLogUri = {
       getDisplayString()
    }

    String getDisplayString() {
        return softwareName + ' ' + softwareVersion
    }

    String toString() {
        getDisplayString()
    }

    static List<Software> getAvailableSoftware(Object obj) {
        String query
        println "Got Object $obj"
        if (obj instanceof Computer) {
            def computer = (Computer) obj
            query = "not exists (select 1 from COMPUTER_INSTALLED_SOFTWARE cis where cis.computer_id = $computer.id and cis.software_id = this_.id) "
        } else if (obj instanceof System) {
            def system = (System)obj
            query = "not exists (select 1 from SYSTEM_USES_SOFTWARE cis where cis.system_id = $system.id and cis.software_id = this_.id) "
        }
        createCriteria().list() {
            sqlRestriction(query)
        }
    }

}

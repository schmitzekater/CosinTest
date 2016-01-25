package de.schmitzekater

class Software extends QualifiableObject{
    String softwareName
    String softwareVersion
    String softwareIqOq

    static auditable = true
    static hasOne = [softwareVendor: Vendor]
    static hasMany = [computer: Computer, system: System]
    static belongsTo = [System, Computer]
    static mappedBy = [system: 'software']

    static constraints = {
        softwareName blank: false, maxSize: 50
        softwareVersion blank: false
        softwareIqOq blank: true, nullable: true
        softwareVendor nullable: true
        system nullable: true
        computer nullable: true
    }

    String getDisplayString() {
        return softwareName + ' ' + softwareVersion
    }

    String toString() {
        getDisplayString()
    }

    static List<Software> getAvailableSoftware(Object obj) {
        if (obj instanceof Computer) {
            def computer = (Computer) obj
            String query = "not exists (select 1 from COMPUTER_INSTALLED_SOFTWARE cis where cis.computer_id = $computer.id and cis.software_id = this_.id) "
            createCriteria().list() {
                sqlRestriction(query)
            }
        } else if (obj instanceof System) {
            createCriteria().list() {
                sqlRestriction('not exists (select 1 from Software s inner join System sys on s.id = sys.software_id where sys.software_id = this_.id) ')
            }
        }
    }

}

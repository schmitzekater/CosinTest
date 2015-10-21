package de.schmitzekater

class Software {
    String softwareName
    String softwareVersion
    String softwareIqOq

    static hasMany = [qualifications: Qualification]
    static hasOne = [softwareVendor: Vendor]
    static belongsTo = [system: System, computer: Computer]
    static constraints = {
        softwareName blank: false, maxSize: 50
        softwareVersion blank: false
        softwareIqOq blank: true
        softwareVendor nullable: true
        qualifications nullable: true
        system nullable: true
        computer nullable: true
    }

    String getDisplayString() {
        return softwareName
    }

}

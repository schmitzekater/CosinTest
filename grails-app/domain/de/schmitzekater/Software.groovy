package de.schmitzekater

class Software extends QualifiableObject{
    String softwareName
    String softwareVersion
    String softwareIqOq


    static hasOne = [softwareVendor: Vendor]
    static belongsTo = [system: System, computer: Computer]

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

}

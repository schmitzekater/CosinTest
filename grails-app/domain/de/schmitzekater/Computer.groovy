package de.schmitzekater


class Computer {
    String computerName

    static hasOne = [computerVendor: Vendor, computerLocation: Location, computerRole: ComputerRole]
    static hasMany = [installedSoftware: Software]
    static belongsTo = [system: System]
    static constraints = {
        computerName blank: false, maxSize: 50
        computerVendor nullable: true
        computerLocation nullable: true
        computerRole nullable: true
        installedSoftware nullable: true
        //unit nullable: true
        system nullable: true
    }

    String getDisplayString() {
        return computerName
    }

    String toString() {
        getDisplayString()
    }

}

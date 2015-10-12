package de.schmitzekater

import static de.schmitzekater.ComputerRole.*

class Computer {
    String ComputerName

    static hasOne = [computerVendor: Vendor, computerLocation: Location, computerRole: ComputerRole]
    static hasMany = [installedSoftware: Software]
    static belongsTo = [unit: Unit, system: System]
    static constraints = {
        computerName blank: false, maxSize: 50
        computerVendor nullable: true
        computerLocation nullable: true
        computerRole nullable: true
        installedSoftware nullable: true
    }

    public Computer(String name, Vendor vendor, Unit unit, Location location, ComputerRole computerRole){
        computerName = name
        computerVendor = vendor
        this.unit = unit
        computerLocation = location
        computerRole = computerRole
    }
    public Computer(String name, Vendor vendor, Unit unit, Location location){
        computerName = name
        computerVendor = vendor
        this.unit = unit
        computerLocation = location
        computerRole = UNSPEC_SERVER
    }
    public Computer(String name){
        computerName = name
        computerRole = UNSPEC_CLIENT
    }
}

package de.schmitzekater


class Computer {
    String computerName

    static hasOne = [computerVendor: Vendor, computerLocation: Location, computerRole: ComputerRole]
    static hasMany = [installedSoftware: Software]
    static belongsTo = [system: System]
  /*  static mapping = {
        system joinTable: [name: 'mm_system_computer', key: 'mm_computer_id']
    }*/
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

class Client extends Computer{}
class Server extends Computer{}

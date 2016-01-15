package de.schmitzekater


class Computer implements Serializable{
    private static final long serialVersionUID = 1

    String computerName
    static auditable = true
    static hasOne = [computerVendor: Vendor, computerLocation: Location]
    static hasMany = [installedSoftware: Software]
    static mapping = {
        computerVendor sort: 'name', order: 'asc'
    }
    static constraints = {
        computerName blank: false, maxSize: 50, unique: true
        computerVendor nullable: true
        computerLocation nullable: true
        installedSoftware nullable: true
    }

    String getDisplayString() {
        return computerName
    }

    String toString() {
        getDisplayString()
    }
    Set<SystemRole> getSystemRoles(){
        SystemRole.findAllByComputer(this)
    }
    Set<SystemRole> getSystemRolesBySystem(System system){
        SystemRole.findAllByComputerAndSystem(this, system)
    }

}


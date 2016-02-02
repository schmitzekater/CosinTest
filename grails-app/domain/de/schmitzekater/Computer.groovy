package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to handle Computers.
 * Computer can have certain Roles inside a System.
 *
 * Handled via @ComputerController and @QualifiableObjectService
 */

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

    /** Get all Roles from a specific Computer in all Systems */
    Set<SystemRole> getSystemRoles(){
        SystemRole.findAllByComputer(this)
    }

    /** Get only the Roles of a Computer for a specific System */
    Set<SystemRole> getSystemRolesBySystem(System system){
        SystemRole.findAllByComputerAndSystem(this, system)
    }

}


package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to represent Systems.
 * A System may consist of various combinations of Software and Systems.
 *
 * Handled via @SystemController
 * TODO: Implement SystemService
 */
class System implements Serializable{
    private static final long serialVersionUID = 1
    String systemName
    boolean isActive
    File dataFlow
    Date retirementDate // TODO Set it manually
    String area


    static belongsTo = [Person, Department]
    static hasMany = [units: Unit, usesSoftware: Software, systemOwner: Person, processOwner: Person]
    static hasOne = [systemDataCategory: DataCategory, systemDepartment: Department]
    static mappedBy = [ systemOwner: 'systemOwnerSystem', processOwner: 'processOwnerSystem']

    static auditable = true

    static constraints = {
        systemName blank: false, maxSize: 50
        dataFlow nullable: true, display: false
        systemDepartment nullable: true
        systemOwner nullable: true
        processOwner nullable: true
        units nullable: true
        systemDataCategory nullable: true
        area nullable: false, inList: ["GCP", "GLP", "GMP", "GxP"]
        usesSoftware nullable: true
        retirementDate nullable: true, display: false
    }

    String getDisplayString() {
        return systemName
    }

    String toString() {
        getDisplayString()
    }

    /**
     * Inspired by the Spring Security core plugin. Many-to-Many mapping of Computers and Systems
     * Method to get all computer that are bound to this system
     */
    Set<Computer> getComputer(){
        SystemRole.findAllBySystem(this)*.computer
    }


    Set<SystemRole> getSystemRole(){
        SystemRole.findAllBySystem(this)
    }

    def onChange = { oldMap, newMap ->
        oldMap.each({ key, oldVal ->
            if (oldVal != newMap[key]) {
                log.info " * $key changed from $oldVal to " + (newMap[key] == null ? 'null' : newMap[key]) + " for " + getDisplayString()
            }
        })

    }
}

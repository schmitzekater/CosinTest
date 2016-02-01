package de.schmitzekater

import grails.transaction.Transactional

/**
 * @author Alexander Schmitz
 *
 * This controller handles the Domain class System
 */
import static org.springframework.http.HttpStatus.CREATED
import org.springframework.web.multipart.MultipartHttpServletRequest

class SystemController {
    static scaffold = System
    static defaultAction = "list"
    def systemRoleService               /** Dependency Injection for the SystemRoleService  */
    def fileHandleService               /** Dependency Injection for the FileHandleService  */

    def index() {
        redirect action: list(), params: params
    }

    def show() {
        redirect action: 'detail', params: params
    }

    /*
    Tabular view of al Systems
     */
    def list() {
        if (!params.max) params.max = 10
        def systems = System.list(params)
        render view: "/layouts/list", model: [model: systems, count: System.count]
    }

    /*
    Method to retire a specific System
    TODO: Refactor to Service.
    TODO: Add views
     */
    def retire(System system) {
        system.setIsActive(false)
        system.setRetirementDate(params.retirementDate)
        if (system.save(failOnError: true)) {
            flash.message = message(code: 'system.successful.retired', args: ['System', system.systemName])
            log.info(flash.message)
            redirect action: 'list'
        } else {
            flash.error = message(code: 'error.retiring.system', args: ['System', system.systemName])
            log.error(flash.error)
        }
    }

    /*
    Method to edit the dataflow file of a system.
     */
    def editDataFlowFile(System system){
        File dataFlow = fileHandleService.uploadDataflowFile(request as MultipartHttpServletRequest, system)
        if(dataFlow){
            if(system.dataFlow){
                // Delete the existing dataflow file.
                // User gets a warning displayed before a new upload.
                if(fileHandleService.deleteDataflowFile(system.dataFlow)){
                    log.info("Deleted old dataflow file $system.dataFlow from System $system.systemName.")
                }
                else{
                    log.error("Could not delete old dataflow file from System $system.systemName")
                }
            }
            // Set the new dataflow File
            //TODO: Refactor to service
            system.setDataFlow(dataFlow)
            if(system.save(failOnError: true)){
                flash.message = message(code: 'system.dataFlow.successful.edited', args: ['System', system.systemName, dataFlow.name])
                log.info(flash.message)
                redirect action: 'detail', id: system.id
            }
        }
        else{
            flash.error = message(code: 'error.dataFlow.missing', args: ['System', system.systemName])
            log.error(flash.error)
            redirect action: 'editDataFlow', id: system.id
        }
    }

    /*
    Render view to edit the dataflow file
     */
    def editDataFlow(System system){
        model:
        [system: system]
    }


    /*
    Method to save a new System.
     */
    def createSystem() {
        def system = new System(params)
        system.isActive = true
        if (system.validate()) {
            system.save(failOnError: true)
            flash.message = message(code: 'default.created.message', args: ['System', system.systemName])
            redirect(action: 'list')//, params: system.id)
        } else {
            flash.error = message(code: 'default.not.created.message', args: ['System', system.systemName])
            log.error('System could not be created')
        }

    }

    /*
    Method to add an existing Software to System.
     */
    def addSoftware(System system) {
        def software = Software.get(params.software)
        system.addToUsesSoftware(software)
        flash.message = message(code: 'software.added.to.system', args:[software.softwareName, system.systemName])
        redirect action: 'detail', id: system.id
    }

    /*
    Method to remove a Software from a system.
     */
    def removeSoftware(System system) {
        def software = Software.get(params.software)
        system.removeFromUsesSoftware(software)
        flash.message = message(code: 'software.removed.from.system', args:[software.softwareName, system.systemName])
        redirect action: 'detail', id: system.id
    }

    /*
    Method to add a Computer to the System.
    Creates a new SystemRole (Role of the Computer within the system)
     */
    def addComputer(System system) {
        def computer = Computer.get(params.computer)
        def computerRole = ComputerRole.get(params.computerRole)
        def systemRole = systemRoleService.createSystemRole(computer, system, computerRole)
        flash.message = message(code: 'systemRole.created', args:[computer.computerName, system.systemName, computerRole.displayString])
        redirect action: 'detail', id: system.id
    }

    /*
    Method to remove a Computer from a System.
    Removes the SystemRoles for this Computer and System as well
     */
    def removeComputer(System system) {
        def computer = Computer.get(params.computer)
        SystemRole.remove(computer, system, true)
        flash.message = message(code:'computer.removed.from.system', args:[computer.computerName, system.systemName])
        redirect action: 'detail', id: system.id
    }

    /*
    Method to add a new Unit to the System
     */
    def addUnit(System system) {
        def unit = Unit.get(params.unit)
        system.addToUnits(unit)
        flash.message = message(code: 'unit.added.to.system', args:[unit.unitName, system.systemName])
        redirect action: 'detail', id: system.id
    }

    /*
    Method to remove an Unit from a System
     */
    def removeUnit(System system) {
        def unit = Unit.get(params.unit)
        system.removeFromUnits(unit)
        flash.message = message(code:'unit.removed.from.system', args:[unit, system])
        redirect action: 'detail', id: system.id
    }

    /*
    View to add a Software to a System
     */
    def addSoftwareToSystem(System system) {
        model:
        [system: system]
    }

    /*
    View to add an Unit to a System
     */
    def addUnitToSystem(System system) {
        model:
        [system: system]
    }


    /*
    View to add a Computer to a System
     */
    def addComputerToSystem(System system) {
        model:
        [system: system]
    }

    /*
    Method to update an existing System
    TODO: Refactor to Service!
     */
    def update(System system) {
        if (system) {
            /* Update System Ownership */
            if (params.systemOwner) {
                def presentSystemOwners = system.systemOwner.collect()
                for (so in presentSystemOwners) {
                    if (!params.systemOwner.contains(so.id.toString())) {
                        /* Delete to old Owners */
                        system.removeFromSystemOwner(so)
                        log.info("Removed ${so.getDisplayString()} as SystemOwner from ${system.getDisplayString()}")
                    }
                }
                params.systemOwner.each {
                    def person = Person.get(it)
                    /* Add the new Owners */
                    system.addToSystemOwner(person)
                    log.info("Added ${person.getDisplayString()} as SystemOwner to System ${system.getDisplayString()}")
                }
            }
            /* Update Process Ownership */
            if (params.processOwner) {
                def presentProcessOwners = system.processOwner.collect()
                for (po in presentProcessOwners) {
                    if (!params.processOwner.contains(po.id.toString())) {
                        /* Delete to old Owners */
                        system.removeFromProcessOwner(po)
                        log.info("Removed ${po.getDisplayString()} as ProcessOwner from ${system.getDisplayString()}")
                    }
                }
                for (processOwner in params.processOwner) {
                    def po = Person.get(processOwner)
                    /* Add the new Owners */
                    system.addToProcessOwner(po)
                    log.info("Added ${po.getDisplayString()} as ProcessOwner to System ${system.getDisplayString()}")
                }
            }
            if (system.save()) {
                flash.message = message(code: 'default.updated.message', args: ['System', system.systemName])
                log.info(flash.message)
                redirect(action: "list")
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['System', system.systemName])
                log.error(flash.error)
                redirect(action: "edit", id: params['id'])
            }

        } else {
            response.sendError(404)
        }

    }

    /*
        Edited the default controller-method to handle the Ownerships.
        TODO: Refactor to Service!
     */

    @Transactional
    def save(System system) {
        if (system == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (system.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond system.errors, view: 'create'
            return
        }
        if (params.systemOwner) {
            for (systemOwner in params.systemOwner) {
                def so = Person.get(systemOwner)
                if (so) system.addToSystemOwner(so)
            }
        }
        if (params.processOwner) {
            for (processOwner in params.processOwner) {
                def po = Person.get(processOwner)
                if (po) system.addToProcessOwner(po)
            }
        }
        system.save flush: true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'system.label', default: 'System'), system.id])
                redirect system
            }
            respond system, [status: CREATED]
        }
    }

    /*
    Detailed view of a single System
     */
    def detail() {
        def system = System.findById(params.id)
        render view: "/layouts/detail", model: [system: system]
    }

    /*
    Exception Handling
     */
    def handleFileExistsException(FileExistsException fe){
        if(fe.message=="File exists"){
            flash.error = message(code: "error.file.exists", args:[fe.existingFile.absolutePath])
            log.error(flash.error)
        }


    }


}

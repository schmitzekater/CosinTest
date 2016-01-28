package de.schmitzekater

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED

class SystemController {
    static scaffold = System
    static defaultAction = "list"
    def systemRoleService

    def index() {
        redirect action: list(), params: params
    }

    def show() {
        redirect action: 'detail', params: params
    }

    def list() {
        if (!params.max) params.max = 10
        def systems = System.list(params)
        render view: "/layouts/list", model: [model: systems, count: System.count]
    }

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


    def createSystem() {
        def system = new System(params)
        system.isActive = true
        if (system.validate()) {
            system.save(failOnError: true)
            flash.message = message(code: 'default.created.message', args: ['System', system.systemName])
            redirect(action: 'list')//, params: system.id)
        } else {
            flash.message = message(code: 'default.not.created.message', args: ['System', system.systemName])
            logger.error('System could not be created')
        }

    }

    def addSoftware(System system) {
        def software = Software.get(params.software)
        //def system = System.get(params.id)
        system.addToUsesSoftware(software)
        redirect action: 'detail', id: system.id
    }

    def removeSoftware() {
        def software = Software.get(params.software)
        def system = System.get(params.id)
        system.removeFromUsesSoftware(software)
        redirect action: 'detail', id: system.id
    }

    def addComputer() {
        def system = System.get(params.id)
        def computer = Computer.get(params.computer)
        def computerRole = ComputerRole.get(params.computerRole)
        def systemRole = systemRoleService.createSystemRole(computer, system, computerRole)
        redirect action: 'detail', id: params.id
    }

    def removeComputer() {
        def system = System.get(params.id)
        def computer = Computer.get(params.computer)
        SystemRole.remove(computer, system, true)
        redirect action: 'detail', id: system.id
    }

    def addUnit() {
        def unit = Unit.get(params.unit)
        def system = System.get(params.id)
        system.addToUnits(unit)
        redirect action: 'detail', id: system.id
    }

    def removeUnit() {
        def unit = Unit.get(params.unit)
        def system = System.get(params.id)
        system.removeFromUnits(unit)
        redirect action: 'detail', id: system.id
    }

    def addSoftwareToSystem(System system) {
        model:
        [system: system]
    }

    def addUnitToSystem(System system) {
        model:
        [system: system]
    }

    def addComputerToSystem(System system) {
        model:
        [system: system]
    }

    def update(System system) {
        if (system) {
            /* Update System Ownership */
            if (params.systemOwner) {
                def presentSystemOwners = system.systemOwner.collect()
                for (so in presentSystemOwners) {
                    if (!params.systemOwner.contains(so.id.toString())) {
                        system.removeFromSystemOwner(so)
                        log.info("Removed ${so.getDisplayString()} as SystemOwner from ${system.getDisplayString()}")
                    }
                }
                params.systemOwner.each {
                    def person = Person.get(it)
                    system.addToSystemOwner(person)
                    log.info("Added ${person.getDisplayString()} as SystemOwner to System ${system.getDisplayString()}")
                }
            }
            /* Update Process Ownership */
            if (params.processOwner) {
                def presentProcessOwners = system.processOwner.collect()
                for (po in presentProcessOwners) {
                    if (!params.processOwner.contains(po.id.toString())) {
                        system.removeFromProcessOwner(po)
                        log.info("Removed ${po.getDisplayString()} as ProcessOwner from ${system.getDisplayString()}")
                    }
                }
                for (processOwner in params.processOwner) {
                    def po = Person.get(processOwner)
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
        Edited the default controller-method.
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

    def detail() {
        def system = System.findById(params.id)
        render view: "/layouts/detail", model: [system: system]
    }


}

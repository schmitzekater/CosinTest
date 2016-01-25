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

    def show(){
        redirect action: 'detail', params: params
    }

    def list() {
        if(!params.max) params.max = 10
        def systems = System.list(params)
        render view:"/layouts/list", model: [model:systems, count: System.count]
    }

    def createSystem() {
        def system = new System(params)
        system.isActive = true
        if (system.validate()){
            system.save(failOnError: true)
           flash.message = message(code: 'default.created.message', args: ['System', system.systemName])
            redirect(action: 'list')//, params: system.id)
        } else {
            flash.message = message(code: 'default.not.created.message', args:['System', system.systemName])
            logger.error('System could not be created')
        }

    }

    def addSoftware(System system){
        def software = Software.get(params.software)
        //def system = System.get(params.id)
        system.addToUsesSoftware(software)
        redirect action: 'detail', id: system.id
    }
    def removeSoftware(){
        def software = Software.get(params.software)
        def system = System.get(params.id)
        system.removeFromUsesSoftware(software)
        redirect action: 'detail', id: system.id
    }

    def addComputer(){
        def system = System.get(params.id)
        def computer = Computer.get(params.computer)
        def computerRole = ComputerRole.get(params.computerRole)
        def systemRole = systemRoleService.createSystemRole(computer, system, computerRole)
        redirect action: 'detail', id: params.id
    }

    def removeComputer(){
        def system = System.get(params.id)
        def computer= Computer.get(params.computer)
        SystemRole.remove(computer, system, true)
        redirect action: 'detail', id: system.id
    }

    def addUnit(){
        def unit = Unit.get(params.unit)
        def system = System.get(params.id)
        system.addToUnits(unit)
        redirect action: 'detail', id: system.id
    }
    def removeUnit(){
        def unit = Unit.get(params.unit)
        def system = System.get(params.id)
        system.removeFromUnits(unit)
        redirect action: 'detail', id: system.id
    }

    def addSoftwareToSystem(System system){
        model: [system: system]
    }

    def addUnitToSystem(System system){
        model: [system: system]
    }

    def addComputerToSystem(System system){
        model: [system: system]
    }

    def update() {
        def system = System.findById(params['id'])

        if (system) {
            if (params.systemOwner){
                for (systemOwner in params.systemOwner){
                    def so = Person.get(systemOwner)
                    if(so) system.addToSystemOwner(so)
                }
            }
            if (params.processOwner){
                for (processOwner in params.processOwner){
                    def po = Person.get(processOwner)
                    if(po) system.addToProcessOwner(po)
                }
            }
            def oldSystemName = system.systemName
            system.properties = params
            if (system.save()) {
                flash.message = message(code: 'default.updated.message', args: ['System', system.systemName])
                redirect(action: "list")
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['System', oldSystemName])
                redirect(action: "edit", id: params['id'])
            }

        } else {
            //  response.sendError(404)
        }

    }

    /*
        Edited the default controller-method.
     */
    @Transactional
    def save(System system) {
        if (system== null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (system.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond system.errors, view: 'create'
            return
        }

        system.save flush: true
        if (params.systemOwner){
            for (systemOwner in params.systemOwner){
                def so = Person.get(systemOwner)
                if(so) system.addToSystemOwner(so)
            }
        }
        if (params.processOwner){
            for (processOwner in params.processOwner){
                def po = Person.get(processOwner)
                if(po) system.addToProcessOwner(po)
            }
        }

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

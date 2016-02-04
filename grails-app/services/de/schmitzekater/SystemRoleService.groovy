package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class SystemRoleService {

    def createSystemRole(Computer computer, System system, ComputerRole cr) {
        if(!SystemRole.exists(computer.id, system.id, cr.id))
        {
            true
        }
        else{
            false
        }

    }
}

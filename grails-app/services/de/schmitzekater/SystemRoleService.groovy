package de.schmitzekater

import grails.transaction.Transactional

/**
 * @author Alexander Schmitz
 *
 * Service to create SystemRoles.
 * One computer might have multiple Roles in a System, this is achieved with this service.
 */
@Transactional
class SystemRoleService {

    def createSystemRole(Computer computer, System system, ComputerRole cr) {
        if(!SystemRole.exists(computer.id, system.id, cr.id))
        {
            def systemRole = SystemRole.create(computer, system, cr, true)
            if (systemRole) true
        }
        else{
            false
        }

    }
}

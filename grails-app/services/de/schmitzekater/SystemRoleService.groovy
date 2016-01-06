package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class SystemRoleService {

    def createSystemRole(Computer computer, System system, ComputerRole cr) {
        def sr = SystemRole.create(computer, system, cr, true)
        return sr
    }
}

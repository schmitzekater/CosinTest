package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ComputerRoleService {

    def createComputerRole(String role) {
        def cr = new ComputerRole(role: role)
        if (cr.validate()&&cr.save()) return cr
        else throw new ComputerRoleException(message: 'Creation Error', role: cr)
    }
}

class ComputerRoleException extends RuntimeException{
    String message
    ComputerRole role
}
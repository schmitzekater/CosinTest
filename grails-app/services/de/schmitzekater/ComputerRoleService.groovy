package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ComputerRoleService {
    def messageSource
    def localeResolver

    def createComputerRole(String role) {
        def cr = new ComputerRole(role: role)
        if (cr.validate()&&cr.save()) return cr
        else{
            def locale = localeResolver.defaultLocale // Not working very well. Displays german message on english page -.-
            if(!cr.validate()){
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new ComputerRoleException(message: text, role: cr)
            }
            else{
                def text = messageSource.getMessage('error.save', null, locale)
                throw new ComputerRoleException(message: text, role: cr)
            }
        }
    }
}

class ComputerRoleException extends RuntimeException{
    String message
    ComputerRole role
}
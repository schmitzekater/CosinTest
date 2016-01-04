package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ConnectionTypeService {
    def messageSource
    def localeResolver
    def createConnectionType(String type) {
        def ct = new ConnectionType(connection: type)
        if (ct.validate()&&ct.save()) return ct
        else{
            def locale = localeResolver.defaultLocale // Not working very well. Displays german message on english page -.-
            if(!ct.validate()){
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new ConnectionTypeException(message: text, type: ct)
            }
            else{
                def text = messageSource.getMessage('error.save', null, locale)
                throw new ConnectionTypeException(message: text, type: ct)
            }
        }
    }
}

class ConnectionTypeException extends RuntimeException{
    String message
    ConnectionType type
}
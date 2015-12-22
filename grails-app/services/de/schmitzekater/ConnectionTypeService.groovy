package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ConnectionTypeService {
    def createConnectionType(String type) {
        def ct = new ConnectionType(connection: type)
        if (ct.validate()&&ct.save()) return ct
        else throw new ConnectionTypeException(message: 'Creation Error', type: ct)
    }
}

class ConnectionTypeException extends RuntimeException{
    String message
    ConnectionType type
}
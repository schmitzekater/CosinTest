package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ModuleTypeService {
    def createModuleType(String type) {
        def mt = new ModuleType(moduleType: type)
        if (mt.validate()&&mt.save()) return mt
        else throw new ModuleTypeException(message: 'Creation Error', moduleType: mt)
    }
}

class ModuleTypeException extends RuntimeException{
    String message
    ModuleType moduleType
}
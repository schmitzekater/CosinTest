package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ModuleTypeService {
    def messageSource
    def localeResolver
    def createModuleType(String type) {
        def mt = new ModuleType(moduleType: type)
        if (mt.validate()&&mt.save()) return mt
        else{
            def locale = localeResolver.defaultLocale // Not working very well. Displays german message on english page -.-
            if(!mt.validate()){
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new ModuleTypeException(message: text, moduleType: mt)
            }
            else{
                def text = messageSource.getMessage('error.save', null, locale)
                throw new ModuleTypeException(message: text, moduleType: mt)
            }
        }
    }
}

class ModuleTypeException extends RuntimeException{
    String message
    ModuleType moduleType
}
package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class ConfigService {

/**
 * @author Alexander Schmitr
 * Service to create new entries for configurable String-Classes.
 */
    def messageSource
    def localeResolver

    def createComputerRole(String role) {
        def cr = new ComputerRole(role: role)
        if (cr.validate() && cr.save()) return cr
        else {
            def locale = localeResolver.defaultLocale
            // Not working very well. Displays german message on english page -.-
            // Possible (dirty) solution: Throw fixed text and handle the text in Error Controller, to send flash.error
            if (!cr.validate()) {
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new ComputerRoleException(message: text, role: cr)
            } else {
                def text = messageSource.getMessage('error.save', null, locale)
                throw new ComputerRoleException(message: text, role: cr)
            }
        }
    }


    def createConnectionType(String type) {
        def ct = new ConnectionType(connection: type)
        if (ct.validate() && ct.save()) return ct
        else {
            def locale = localeResolver.defaultLocale
            // Not working very well. Displays german message on english page -.- See ComputerRoleService
            if (!ct.validate()) {
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new ConnectionTypeException(message: text, type: ct)
            } else {
                def text = messageSource.getMessage('error.save', null, locale)
                throw new ConnectionTypeException(message: text, type: ct)
            }
        }
    }


    def createDataCategory(String category) {
        def dc = new DataCategory(category: category)
        if (dc.validate() && dc.save()) return dc
        else {
            def locale = localeResolver.defaultLocale
            // Not working very well. Displays german message on english page -.-
            if (!dc.validate()) {
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new DataCategoryException(message: text, dataCategory: dc)
            } else {
                def text = messageSource.getMessage('error.save', null, locale)
                throw new DataCategoryException(message: text, dataCategory: dc)
            }
        }
    }

    def createModuleType(String type) {
        def mt = new ModuleType(moduleType: type)
        if (mt.validate() && mt.save()) return mt
        else {
            def locale = localeResolver.defaultLocale
            // Not working very well. Displays german message on english page -.-
            if (!mt.validate()) {
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new ModuleTypeException(message: text, moduleType: mt)
            } else {
                def text = messageSource.getMessage('error.save', null, locale)
                throw new ModuleTypeException(message: text, moduleType: mt)
            }
        }
    }

    def createQualificationType(String type) {
        def qt = new QualificationType(type: type)
        if (qt.validate()&&qt.save()) return qt
        else{
            def locale = localeResolver.defaultLocale // Not working very well. Displays german message on english page -.-
            if(!qt.validate()){
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new QualificationTypeException(message: text, type: qt)
            }
            else{
                def text = messageSource.getMessage('error.save', null, locale)
                throw new QualificationTypeException(message: text, type: qt)
            }
        }
    }
}

class ComputerRoleException extends RuntimeException {
    String message
    ComputerRole role
}

class ConnectionTypeException extends RuntimeException {
    String message
    ConnectionType type
}

class DataCategoryException extends RuntimeException {
    String message
    DataCategory dataCategory
}

class ModuleTypeException extends RuntimeException {
    String message
    ModuleType moduleType
}
class QualificationTypeException extends RuntimeException{
    String message
    QualificationType type
}

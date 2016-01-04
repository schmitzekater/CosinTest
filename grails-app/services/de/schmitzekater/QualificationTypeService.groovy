package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class QualificationTypeService {
    def messageSource
    def localeResolver
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

class QualificationTypeException extends RuntimeException{
    String message
    QualificationType type
}

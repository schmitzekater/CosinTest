package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class QualificationTypeService {
    def createQualificationType(String type) {
        def qt = new QualificationType(type: type)
        if (qt.validate()&&qt.save()) return qt
        else throw new QualificationTypeException(message: 'Creation Error', type: qt)
    }
}

class QualificationTypeException extends RuntimeException{
    String message
    QualificationType type
}

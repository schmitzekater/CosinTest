package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class QualificationService {

    def createQualification(Date qualificationDate, String qualificationType, QualifiableObject qualificationObject, String comment) {
        println "Im Service"

        def qual = new Qualification(qualificationDate: qualificationDate, qualificationType: QualificationType.findByType(qualificationType),
                qualificationObject: qualificationObject, comment: comment)
        if (qual.validate()&&qual.save()) return qual
        else throw new QualificationException(message: 'Qualification Error', qualification: qual, qualifiableObject: qualObj)
    }
    def createQualification(){

    }

}


class QualificationException extends RuntimeException{
    String message
    Qualification qualification
    QualifiableObject qualifiableObject
}
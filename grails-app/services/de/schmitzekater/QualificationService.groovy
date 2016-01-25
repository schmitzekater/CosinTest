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

    static getCalibrationList(Class aclass, int max, int offset, Date dateFrom, Date dateUntil, String sortBy, String orderBy) {
        def c = Qualification.createCriteria()
        def qualificationList = c.list(max: max, offset: offset) {
            qualificationObject {
                eq("class", aclass)
            }
            qualificationType {
                ilike('type', 'Calibration')
            }
            and {
                between("qualificationDate", dateFrom, dateUntil)
            }
            order(sortBy, orderBy)
        }
        qualificationList
    }

    static getQualificationList(Class aclass, int max, int offset, Date dateFrom, Date dateUntil, String sortBy, String orderBy) {
        def c = Qualification.createCriteria()
        def qualificationList = c.list(max: max, offset: offset) {
            qualificationObject {
                eq("class", aclass)
            }
            and {
                between("qualificationDate", dateFrom, dateUntil.plus(1))
                // Not nice, but otherwise values from today are not shown!!!!!!!
            }
            order(sortBy, orderBy)
        }
        qualificationList
    }

}


class QualificationException extends RuntimeException{
    String message
    Qualification qualification
    QualifiableObject qualifiableObject
}
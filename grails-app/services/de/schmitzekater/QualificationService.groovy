package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class QualificationService {

    def fileHandleService
    def attachmentFile

    def createQualification(Date qualificationDate, String qualificationType, QualifiableObject qualificationObject, String comment, MultipartHttpServletRequest request) {
        if(request){
            // Upload the attachment
            attachmentFile = fileHandleService.uploadQualificationFile(request, qualificationObject, qualificationDate)
        }
        // Create a new Qualification
        def qual = new Qualification(qualificationDate: qualificationDate, qualificationType: QualificationType.findByType(qualificationType),
                qualificationObject: qualificationObject, comment: comment, attachment: attachmentFile)
        if (qual.validate()&&qual.save()) return qual
        else throw new QualificationException(message: 'Qualification Error', qualification: qual, qualifiableObject: qualificationObject)
    }


    static getCalibrationList(Class aclass, Map params){
        def c = Qualification.createCriteria()
        def qualificationList = c.list(max: params.max, offset: params.offset) {
            qualificationObject {
                eq("class", aclass)
            }
            qualificationType {
                ilike('type', 'Calibration')
            }
            and {
                between("qualificationDate", params.dateFrom, params.dateUntil.plus(1))
            }
            order(params.sortBy, params.orderBy)
        }
        qualificationList
    }

    static getQualificationList(Class aclass, Map params) {
        def c = Qualification.createCriteria()
        def qualificationList = c.list(max: params.max, offset: params.offset) {
            qualificationObject {
                eq("class", aclass)
            }
            and {
                between("qualificationDate", params.dateFrom, params.dateUntil.plus(1))
                // Not nice, but otherwise values from today are not shown!!!!!!!
            }
            order(params.sortBy, params.orderBy)
        }
        qualificationList
    }

}


class QualificationException extends RuntimeException{
    String message
    Qualification qualification
    QualifiableObject qualifiableObject
}
package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

/**
 * @author Alexander Schmitz
 *
 * Service to create new Qualifications for QualifiableObjects (Module & Software)
 * File upload vie @FileHandleService
 */
@Transactional
class QualificationService {

    def fileHandleService       /** dependency Injection for the FileHandleService */
    def attachmentFile

    /**
     *
     * @param qualificationDate : Date of the qualification
     * @param qualificationType : Type of Qualification
     * @param qualificationObject : Qualifiable Object where the qualification belongs to
     * @param comment : Comment of the qualification
     * @param request : the request that contains the MultipartFile from the upload form
     * @return new Qualification
     */
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

    /**
     *
     * @param aclass : the class to be looked up (e.g.: Module / Software)
     * @param params : the params Map for the query
     * @return filtered List of Calibrations
     */
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

    /**
     *
     * @param aclass : the class to be looked up (e.g.: Module / Software)
     * @param params : the params Map for the query
     * @return filtered List of Qualifications
     */
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
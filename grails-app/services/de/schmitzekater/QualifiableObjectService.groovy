package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class QualifiableObjectService {

    Date dateFrom
    Date dateUntil
    int max
    int offset
    String sortBy
    String orderBy
    Map params

    def serviceMethod() {

    }

    def checkParams(Map params) {
        max = params.max ? params.max.toInteger() : 25
        sortBy = params.sort ? params.sort : 'qualificationDate'
        orderBy = params.order ? params.order : 'desc'
        offset = params.offset ? params.offset.toInteger() : 0
        if (params.dateFrom instanceof Date) {
            dateFrom = params.dateFrom
        } else if (params.dateFrom instanceof String) {
            dateFrom = Date.parseToStringDate(params.dateFrom)
        } else dateFrom = new Date().minus(14)
        if (params.dateTo instanceof Date) {
            dateUntil = params.dateTo
        } else if (params.dateTo instanceof String) {
            dateUntil = Date.parseToStringDate(params.dateTo)
        } else dateUntil = new Date()
        params.max = max
        params.offset = offset
        params.dateFrom = dateFrom
        params.dateUntil = dateUntil
        params.sortBy = sortBy
        params.orderBy = orderBy
        return params
    }
    def addQualification(Module module, Qualification qualification){
        // Add the Qualification to the module
        if(module.addToQualifications(qualification)){
            // Was the Qualification a Calibration??
            if (qualification.qualificationType.toString().equalsIgnoreCase("Calibration")) {
                // Get the last Calibration of the module
                def latestCalibration = module.lastCalibration
                Date qualDate = qualification.qualificationDate
                if (latestCalibration == null || qualDate > latestCalibration) {
                    // Calculate the next calibration only if there wasn't any or the calibration is the newest.
                    module.setLastCalibration(qualDate)
                    module.setNextCalibration()
                    return true
                }
            }
            else{
                return true
            }
        }
        else {
            return false
        }
    }

    def addQualification(Software software, Qualification qualification){
        if(software.addToQualifications(qualification)){
            def lastQualification = software.lastQualification
            Date qualDate = qualification.qualificationDate
            if(lastQualification ==null || qualDate>lastQualification){
                // Set the latest Qualification for the software
                software.setLastQualification(qualDate)
            }
            if(software.save(failOnError: true)){
                return true
            }
        }
        else{
            return false
        }

    }

    def retireModule(Module module){
        module.setIsActive(false)
        module.setRetirementDate(params.retirementDate)
        return (module.save(failOnError: true))
    }

}

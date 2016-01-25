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

}

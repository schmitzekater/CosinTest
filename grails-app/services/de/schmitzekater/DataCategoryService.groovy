package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class DataCategoryService {
    def createDataCategory(String category) {
        def dc = new DataCategory(category: category)
        if (dc.validate()&&dc.save()) return dc
        else throw new DataCategoryException(message: 'Creation Error', dataCategory: dc)
    }
}

class DataCategoryException extends RuntimeException{
    String message
    DataCategory dataCategory
}
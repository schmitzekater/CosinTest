package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class DataCategoryService {
    def messageSource
    def localeResolver
    def createDataCategory(String category) {
        def dc = new DataCategory(category: category)
        if (dc.validate()&&dc.save()) return dc
        else{
            def locale = localeResolver.defaultLocale // Not working very well. Displays german message on english page -.-
            if(!dc.validate()){
                def text = messageSource.getMessage('error.duplicate.entry', null, locale)
                throw new DataCategoryException(message: text, dataCategory: dc)
            }
            else{
                def text = messageSource.getMessage('error.save', null, locale)
                throw new DataCategoryException(message: text, dataCategory: dc)
            }
        }
    }
}

class DataCategoryException extends RuntimeException{
    String message
    DataCategory dataCategory
}
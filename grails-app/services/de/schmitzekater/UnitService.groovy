package de.schmitzekater

import grails.transaction.Transactional

@Transactional
class UnitService {

    def createUnit(String name){
        def unit = new Unit(unitName: name)
        if(unit.validate()) {
            unit.save()
            return unit
        }
        else throw new UnitException(message: 'Error creating unit', unit: unit)
    }
}

class UnitException extends RuntimeException {
    String message
    Unit unit
}


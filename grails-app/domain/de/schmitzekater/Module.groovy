package de.schmitzekater

import java.text.SimpleDateFormat


class Module extends QualifiableObject{
    String moduleName
    String moduleSerial
    String moduleModel
    String moduleFirmware

    Date productiveDate
    Date retirementDate
    Date lastCalibration
    Date nextCalibration
    def messageSource

    int calibInterval
    String calibPeriod
    boolean needsCalibration
    boolean isActive

    static auditable = true
    static hasOne= [moduleVendor: Vendor, moduleType : ModuleType, moduleConnection : ConnectionType]
    static belongsTo = [unit: Unit]

    static constraints = {
        moduleSerial blank: false, unique: true
        moduleName blank: false
        moduleModel blank: false
        moduleFirmware blank: false
        moduleVendor nullable: true
        moduleType nullable: true
        unit nullable: true

        productiveDate nullable: true, max: new Date(), min: new Date(80,0,0)
        retireDate nullable: true, max: new Date(), min: new Date(80,0,0)
        moduleConnection nullable: true
        needsCalibration nullable: false
        lastCalibration nullable: true
        nextCalibration nullable: true
        calibInterval nullable: true, min: 0, max: 365
        calibPeriod nullable: true, inList: ['Days', 'Weeks', 'Month', 'Years']
    }

    String getDisplayString(){
        return moduleName + ' ('+moduleSerial+')'
    }

    int getCalibInterval(){
        return calibInterval
    }
    String getCalibPeriod(){
        return calibPeriod
    }
    def setNextCalibration(){
        Calendar c = Calendar.getInstance()
        c.setTime(lastCalibration)
        switch (calibPeriod){
            case('Days'): c.add(Calendar.DATE,calibInterval)
                break
            case('Weeks'): c.add(Calendar.DATE, calibInterval*7)
                break
            case('Month'): c.add(Calendar.MONTH, calibInterval)
                break
            case('Years'): c.add(Calendar.YEAR, calibInterval)
                break
        }
        nextCalibration = c.getTime()
    }
    String getCalibrationDisplayString(){
        if(calibInterval == 1 && calibPeriod == 'Days') return 'daily'
        if(calibInterval == 1 && calibPeriod == 'Weeks') return 'weekly'
        if(calibInterval == 1 && calibPeriod == 'Month') return 'monthly'
        if(calibInterval == 1 && calibPeriod == 'Years') return 'yearly'
        if(calibInterval > 1 && calibPeriod == 'Days') return calibInterval + ' Days'
        if(calibInterval > 1 && calibPeriod == 'Weeks') return calibInterval + ' Weeks'
        if(calibInterval > 1 && calibPeriod == 'Month') return calibInterval + ' Months'
        if(calibInterval > 1 && calibPeriod == 'Years') return calibInterval + ' Years'
    }

    def beforeUpdate(){
        /**
         * This function is fired before the object is updated in the database.
         * Similar function is "beforeInsert()", when the object is initially saved
         */
        if(needsCalibration && lastCalibration!=null){
                setNextCalibration()
            }
        this.save(failOnError: true)
    }

    def beforeInsert(){
        if(needsCalibration && lastCalibration!=null){
            setNextCalibration()
        }
        this.save(failOnError: true)
    }

    String toString() {
        getDisplayString()
    }

    static List<Module> getAvailableModules() {
        /*  Get the list of Modules, that are not bound to a unit
            Inspired by: http://stackoverflow.com/questions/30623429/grails-how-to-use-exists-notexists-within-createcriteria
            If "tablePerHierarchy false" in Qualifiable Object replace "Qualifiable_Object" with "Module"
         */
        createCriteria().list() {
            sqlRestriction('not exists (select 1 from Qualifiable_Object m inner join Unit u on u.id = m.unit_id where m.id = this_.id) ')
        }
    }
}

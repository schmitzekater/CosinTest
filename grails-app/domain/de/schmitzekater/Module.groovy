package de.schmitzekater

import java.text.SimpleDateFormat

/**
 * @author Alexander Schmitz
 *
 * Domain class to handle different Modules.
 * Modules are part of an Unit
 * Example: Unit containing a MassSpectrometer, Autosampler, HPLC-Pump, Degasser and Column Oven
 *
 * Modules might have to be calibrated
 */
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
        moduleSerial blank: false, unique: true, size: 3..50
        moduleName blank: false, size: 3..100
        moduleModel blank: false
        moduleFirmware blank: false, size: 2..100
        moduleVendor nullable: true
        moduleType nullable: true
        unit nullable: true

        productiveDate nullable: true, max: new Date().plus(1), min: new Date(80, 0, 0)
        // +1 accepts now + 1 days: Otherwise cannot be applied "now".
        // minDate = 01.01.1980
        retirementDate nullable: true, max: new Date().plus(1), min: new Date(80, 0, 0)
        // +1 accepts now + 1 days: Otherwise cannot be applied "now".
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
    /** calculate the Date for the next calibration.
     * Based on calibration interval and period
     * @return nextCalibration
     */
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

    /** Get a nicer format for displaying the calibration interval */
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
         * Similar function is "beforeInsert()", when the object is initially saved.
         * Next Calibration date is calculated.
         */
        if(needsCalibration && lastCalibration!=null){
                setNextCalibration()
            }
        this.save(failOnError: true)
    }

    /** See above. Upon first storage the next calibration Date is calculated if needed. */
    def beforeInsert(){
        if(needsCalibration && lastCalibration!=null){
            setNextCalibration()
        }
        this.save(failOnError: true)
    }

    String toString() {
        getDisplayString()
    }

    /*  Get the list of Modules, that are not bound to a unit
            Inspired by: http://stackoverflow.com/questions/30623429/grails-how-to-use-exists-notexists-within-createcriteria
            If "tablePerHierarchy  false" in Qualifiable Object replace "Qualifiable_Object" with "Module"
         */
    static List<Module> getAvailableModules() {
        createCriteria().list() {
            sqlRestriction('not exists (select 1 from Qualifiable_Object m inner join Unit u on u.id = m.unit_id where m.id = this_.id) ')
        }
    }
}

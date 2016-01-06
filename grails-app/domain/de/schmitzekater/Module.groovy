package de.schmitzekater
import org.springframework.context.i18n.LocaleContextHolder as LCH

class Module extends QualifiableObject{
    String moduleName
    String moduleSerial
    String moduleModel
    String moduleFirmware

    Date productiveDate
    Date retireDate
    Date lastCalibration
    Date nextCalibration
    def messageSource

    int calibInterval
    String calibPeriod
    boolean needsCalibration

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
        calibPeriod nullable: true, inList: ['D', 'W', 'M', 'Y']
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
        int days
        switch (calibPeriod){
            case('D'): days = 1
                break
            case('W'): days = 7
                break
            case('M'): days = 30
                break
            case('Y'): days = 365
                break
        }
        /**
         * TODO: Fix monthly values and regard leap-years
         */
        nextCalibration = lastCalibration + (days*calibInterval)
    }
    String getCalibrationDisplayString(){
        if(calibInterval == 1 && calibPeriod == 'D') return 'daily'
        if(calibInterval == 1 && calibPeriod == 'W') return 'weekly'
        if(calibInterval == 1 && calibPeriod == 'M') return 'monthly'
        if(calibInterval == 1 && calibPeriod == 'Y') return 'yearly'
        if(calibInterval > 1 && calibPeriod == 'D') return calibInterval + ' Days'
        if(calibInterval > 1 && calibPeriod == 'W') return calibInterval + ' Weeks'
        if(calibInterval > 1 && calibPeriod == 'M') return calibInterval + ' Months'
        if(calibInterval > 1 && calibPeriod == 'Y') return calibInterval + ' Years'
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
         */
        createCriteria().list() {
            sqlRestriction('not exists (select 1 from Module m inner join Unit u on m.id = u.module_id where u.module_id = this_.id) ')
        }
    }
}

package de.schmitzekater

class Module {
    String moduleName
    String moduleSerial
    String moduleModel
    String moduleFirmware

    Date productiveDate
    Date retireDate

    float calibInterval //measured in months 1.0 = monthly, 0.5 = 2 weeks, 12.0 = yearly
    boolean needsCalibration

    static hasOne= [moduleVendor: Vendor, moduleType : ModuleType, moduleConnection : ConnectionType]
    static belongsTo = [unit: Unit]
    static hasMany = [qualifications: Qualification]

    static constraints = {
        moduleSerial blank: false, unique: true
        moduleName blank: false
        moduleModel blank: false
        moduleFirmware blank: false
        moduleVendor nullable: true
        moduleType nullable: true
        unit nullable: true
        qualifications nullable: true
        productiveDate nullable: true
        retireDate nullable: true
        moduleConnection nullable: true
    }

    String getDisplayString(){
        return moduleName + ' ('+moduleSerial+')'
    }
}

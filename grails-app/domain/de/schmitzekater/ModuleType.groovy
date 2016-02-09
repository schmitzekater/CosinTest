package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different ModuleTypes that a Module can be
 * Handled via @ConfigController and @ConfigService
 * Example: 'Autosampler', 'Mass Spectrometer'
 */
class ModuleType {

    String moduleType
    static hasMany = [module: Module]
    static constraints = {
        moduleType nullable: false, blank: false, unique: true, size: 3..100
        module nullable: true
    }

    String toString(){
        return moduleType
    }

}

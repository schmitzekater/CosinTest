package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different ModuleTypes that a Module can be
 * Handled via @ConfigController and @ModuleTypeService
 * Example: 'Autosampler', 'Mass Spectrometer'
 */
class ModuleType {

    String moduleType
    static hasMany = [module: Module]
    static constraints = {
        moduleType nullable: false, blank: false, unique: true
        module nullable: true
    }

    String toString(){
        return moduleType
    }

}

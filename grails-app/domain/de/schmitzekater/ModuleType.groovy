package de.schmitzekater

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

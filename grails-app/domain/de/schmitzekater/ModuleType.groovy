package de.schmitzekater

class ModuleType {

    String moduleType
    //static belongsTo = [module: Module]
    static constraints = {
        moduleType nullable: false, blank: false
    }

    String toString(){
        return moduleType
    }

}

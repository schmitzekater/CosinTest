package de.schmitzekater

class Vendor {
    String name

    static hasMany = [computer: Computer, module: Module, software: Software]
    static constraints = {
        name blank: false
        computer nullable: true
        module nullable: true
        software nullable: true
    }

    String getDisplayString() {
        return name
    }

}

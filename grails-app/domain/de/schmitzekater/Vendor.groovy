package de.schmitzekater

class Vendor {
    String name

    static auditable = true
    static hasMany = [computer: Computer, module: Module, software: Software]
    static constraints = {
        name blank: false
        computer nullable: true
        module nullable: true
        software nullable: true
    }
    static mapping = {
        sort name: "asc"
    }

    String getDisplayString() {
        return name

    }

    String toString() {
        getDisplayString()
    }

}

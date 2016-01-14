package de.schmitzekater

class Vendor {
    String name
    String url
    Address address


    static hasMany = [computer: Computer, module: Module, software: Software]
    static constraints = {
        name blank: false
        computer nullable: true
        module nullable: true
        software nullable: true
        url nullable: true, url: true
        address nullable: true
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

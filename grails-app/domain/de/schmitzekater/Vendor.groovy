package de.schmitzekater

class Vendor {

    static belongsTo = [computer: Computer, module: Module, software: Software]
    static constraints = {
    }
}

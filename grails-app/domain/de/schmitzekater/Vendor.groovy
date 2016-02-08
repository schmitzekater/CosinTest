package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to represent Vendors of Software or Modules.
 * Handled via @VendorController
 */
class Vendor {
    String name
    String urlOne
    String urlTwo
    String fax
    String phoneOne
    String phoneTwo
    String emailOne
    String emailTwo
    Address address


    static auditable = true
    static hasMany = [computer: Computer, module: Module, software: Software]
    static constraints = {
        name blank: false, size: 3..150
        computer nullable: true
        module nullable: true
        software nullable: true
        urlOne nullable: true, url: true, maxSize: 150
        urlTwo nullable: true, url: true, maxSize: 150
        fax nullable: true, maxSize: 50
        phoneOne nullable: true, maxSize: 50
        phoneTwo nullable: true, maxSize: 50
        emailOne nullable: true, email: true, maxSize: 50
        emailTwo nullable: true, email: true, maxSize: 50
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

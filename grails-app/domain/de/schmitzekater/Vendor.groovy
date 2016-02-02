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
        name blank: false
        computer nullable: true
        module nullable: true
        software nullable: true
        urlOne nullable: true, url: true
        urlTwo nullable: true, url: true
        fax nullable: true
        phoneOne nullable: true
        phoneTwo nullable: true
        emailOne nullable: true, email: true
        emailTwo nullable: true, email: true
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

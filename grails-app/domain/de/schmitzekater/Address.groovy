package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store the address of a vendor.
 * Might be separated into two doman classes (Contact and Address)
 * Could be used for class Person if needed
 */
class Address {

    String streetOne
    String streetTwo
    String zip
    String city
    String county
    String country

    static hasOne = [vendor: Vendor]
    static belongsTo = [Vendor]
    static constraints = {
        streetOne nullable: true
        streetTwo nullable: true
        zip nullable: true
        city nullable: true
        county nullable: true
        country nullable: true
        vendor nullable: true
    }

    String getTableString(){
        "$zip $city ($country)"
    }
}

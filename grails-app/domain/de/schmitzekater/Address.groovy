package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store the address of a vendor.
 * Might be separated into two domain classes (Contact and Address)
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
        streetOne nullable: true, size: 4..100
        streetTwo nullable: true, size: 4..100
        zip nullable: true, size: 3..8
        city nullable: true, size: 3..100
        county nullable: true, size: 2..50
        country nullable: true
        vendor nullable: true
    }

    String getTableString(){
        "$zip $city ($country)"
    }
}

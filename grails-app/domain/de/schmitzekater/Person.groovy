package de.schmitzekater

class Person {
    static hasOne = [user: User, department: Department]
    static hasMany = [system: System]
    String firstName
    String lastName
    String email

    static constraints = {
        firstName size: 3..40, blank: false
        lastName size: 3..40, blank: false
        email email: true , blank: false
        user nullable: true, blank: true
        department nullable: true, blank: true
        system nullable: true
    }
}

package de.schmitzekater

abstract class QualifiableObject {

    static constraints = {
        qualifications nullable: true
    }
    static mapping = {
        sort "qualifications.qualificationDate"
    }
    static hasMany = [qualifications: Qualification]

    String getDisplayString(){}
}

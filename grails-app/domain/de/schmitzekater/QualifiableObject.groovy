package de.schmitzekater

abstract class QualifiableObject {

    static constraints = {
        qualifications nullable: true
    }
    static mapping = {
        //tablePerHierarchy false
    }
    static hasMany = [qualifications: Qualification]

    String getDisplayString(){}
}

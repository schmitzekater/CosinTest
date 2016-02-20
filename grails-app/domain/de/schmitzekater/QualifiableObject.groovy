package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Superclass for Module and Software
 */
abstract class QualifiableObject {

    static constraints = {
        qualifications nullable: true
    }
    static mapping = {
        //tablePerHierarchy false   // this would create distinct tables for Software and Module
    }
    static hasMany = [qualifications: Qualification]

    String getDisplayString(){}
}

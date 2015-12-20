package de.schmitzekater

class QualificationType {
    String type
    static hasMany = [qualification: Qualification]
    static constraints = {
        type nullable: false
        qualification nullable: true
    }

    String toString() {
        return type
    }
}

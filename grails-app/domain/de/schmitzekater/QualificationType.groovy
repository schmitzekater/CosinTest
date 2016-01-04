package de.schmitzekater

class QualificationType {
    String type
    static hasMany = [qualification: Qualification]
    static constraints = {
        type nullable: false, unique: true
        qualification nullable: true
    }

    String toString() {
        return type
    }
}

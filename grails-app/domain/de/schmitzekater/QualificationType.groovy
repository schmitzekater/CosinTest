package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different types of @Qualifications
 * Handled via @ConfigController and QualificationTypeService
 * Example: 'Calibration', 'System Review'
 */
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

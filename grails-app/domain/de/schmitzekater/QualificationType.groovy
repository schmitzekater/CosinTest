package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different types of @Qualifications
 * Handled via @ConfigController and @ConfigService
 * Example: 'Calibration', 'System Review'
 */
class QualificationType {
    String type
    static hasMany = [qualification: Qualification]
    static constraints = {
        type nullable: false, unique: true, size: 3..100
        qualification nullable: true
    }

    String toString() {
        return type
    }
}

package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different DataCategories that a System can have
 * Handled via @ConfigController and @ConfigService
 */
class DataCategory {

    String category
    static hasMany = [system: System]
    static constraints = {
        category nullable: true, unique: true
        system nullable: true
    }

    String toString() {
        return category
    }
}

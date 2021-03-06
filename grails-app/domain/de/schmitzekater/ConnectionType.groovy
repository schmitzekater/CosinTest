package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different Connections that a Module can have inside a Unit
 * Handled via @ConfigController and @ConfigService
 */
class ConnectionType {
    String connection
    static hasMany = [module: Module]
    static constraints = {
        connection nullable: false, unique: true, size: 3..50
        module nullable: true
    }

    String toString() {
        return connection
    }
}

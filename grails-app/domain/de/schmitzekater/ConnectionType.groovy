package de.schmitzekater

class ConnectionType {
    String connection
    static hasMany = [module: Module]
    static constraints = {
        connection nullable: false, unique: true
        module nullable: true
    }

    String toString() {
        return connection
    }
}

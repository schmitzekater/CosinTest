package de.schmitzekater

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

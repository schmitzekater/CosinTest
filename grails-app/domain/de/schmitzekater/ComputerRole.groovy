package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to store different Roles that a Computer can have in a System
 * Handled via @ConfigController and @ConfigService
 */
class ComputerRole {
    String role

    static hasMany = [computer: Computer]
    static constraints = {
        computer nullable: true
        role blank: false, unique: true, size: 5..80
    }

    public ComputerRole(String role) {
        this.role = role
    }

    String getDisplayString() {
        return role
    }

    String toString(){
        return role
    }

}

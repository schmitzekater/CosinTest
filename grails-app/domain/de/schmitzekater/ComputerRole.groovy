package de.schmitzekater

class ComputerRole {
    String role

    static hasMany = [computer: Computer]
    static constraints = {
        computer nullable: true
        role blank: false, unique: true
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

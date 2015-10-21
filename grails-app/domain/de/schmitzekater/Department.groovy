package de.schmitzekater

class Department {
    String departmentName
    static belongsTo = [supervisor: Person]
    static hasMany = [systems: System]

    static constraints = {
        departmentName size: 3..60, blank: false
        supervisor nullable: true
    }

    String getDisplayString() {
        return departmentName
    }

    String toString() {
        return departmentName
    }

}

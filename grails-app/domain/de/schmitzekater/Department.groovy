package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Domain class to handle different Departments inside the company.
 *
 * Handled via @DepartmentController and @DepartmentService
 */
class Department {
    String departmentName
    static belongsTo = [supervisor: Person]
    static hasMany = [systems: System]

    static auditable = true

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

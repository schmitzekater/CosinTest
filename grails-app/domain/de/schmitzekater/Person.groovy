package de.schmitzekater

/**
 * @author: Alexander Schmitz
 *
 * Domain class to handle Persons.
 * Handled visa @PersonController and @PersonService
 * Person can have a an application User (@User)
 * Person can be supervisors of @Department or Owners of a @System (@processOwner, @systemOwner)
 */
class Person {
    static hasOne = [user: User, department: Department]
    static hasMany = [processOwnerSystem: System, systemOwnerSystem: System]
    static auditable = true
    String firstName
    String lastName
    String email

    static constraints = {
        firstName size: 3..40, blank: false
        lastName size: 3..40, blank: false
        email email: true, blank: false
        user nullable: true, blank: true
        department nullable: true, blank: true
        processOwnerSystem nullable: true
        systemOwnerSystem nullable: true
    }

    String toString() {
        getDisplayString()
    }

    String getDisplayString() {
        return lastName + ", " + firstName
    }

    /*  Get the list of Person, that are not bound to a user
           Inspired by: http://stackoverflow.com/questions/30623429/grails-how-to-use-exists-notexists-within-createcriteria
        */
    static List<Person> getAvailablePersons() {
        createCriteria().list() {
            sqlRestriction('not exists (select 1 from Person p inner join User u on p.id = u.person_id where u.person_id = this_.id) ')
        }
    }

    /*
    Get the list of Persons, that are not supervisor of a @Department
     */
    static List<Person> getAvailableSupervisors() {
        createCriteria().list() {
            sqlRestriction('not exists (select 1 from Person p inner join Department d on p.id = d.supervisor_id where d.supervisor_id = this_.id)')
        }
    }

    def onSave = {
        // may optionally refer to newState map
    }
    def onDelete = {
        // may optionally refer to oldState map
    }

    // Integrated via @AuditLogEvent plugin
    def onChange = { oldMap, newMap ->
        oldMap.each({ key, oldVal ->
            if (oldVal != newMap[key] || newMap[key] == null) {
                log.info " * $key changed from $oldVal to " + (newMap[key] == null ? 'null' : newMap[key]) + " for " + getDisplayString()
            }
        })
    }
}

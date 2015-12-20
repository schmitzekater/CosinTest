package de.schmitzekater

class Person {
    static hasOne = [user: User, department: Department]
    static hasMany = [system: System]
    static auditable = true
    String firstName
    String lastName
    String email

    static constraints = {
        firstName size: 3..40, blank: false
        lastName size: 3..40, blank: false
        email email: true , blank: false
        user nullable: true, blank: true
        department nullable: true, blank: true
        system nullable: true
    }

    String toString() {
        getDisplayString()
    }

    String getDisplayString() {
        return lastName + ", " + firstName
    }
    def onSave = {
        println "new User $userId inserted"
        // may optionally refer to newState map
    }
    def onDelete = {
        println "User $userId was deleted"
        // may optionally refer to oldState map
    }
    def onChange = { oldMap, newMap ->
        println "User $userId was changed ..."
        oldMap.each({ key, oldVal ->
            if (oldVal != newMap[key]) {
                println " * $key changed from $oldVal to " + newMap[key] + " for " + userId
            }
        })
    }//*/

}

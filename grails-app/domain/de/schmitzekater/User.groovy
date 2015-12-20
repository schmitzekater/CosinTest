package de.schmitzekater

class User {
    String userId
    String password
    String signature
    Boolean isAdmin
    Boolean isReadOnly
    Date dateCreated
    Date lastPasswordChange

    static auditable = true
    static belongsTo = [person: Person]
    static constraints = {
        userId size: 6..25,  unique: true, nullable: false
        password size: 6..30, blank: false, nullable: false, validator: {passwd, user -> passwd != user.userId}
        signature size: 6..30, blank: false
        isAdmin nullable: true
        isReadOnly nullable: true
        person nullable: false
        lastPasswordChange nullable: true
    }
    String getDisplayString(){
        return userId
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
    }

    String toString() {
        getDisplayString()
    }


}

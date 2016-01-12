package de.schmitzekater

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable{

    private static final long serialVersionUID = 1
    transient springSecurityService
    String username
    String password
    String signature
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    int falsePasswordCount = 0


    User(String username, String password, String signature, Person person){
        //noinspection GroovyAssignabilityCheck
        this()
        this.username = username
        this.password = password
        this.signature = signature
        this.person = person
    }

    static transients = ['springSecurityService']

    static auditable = [mask: ['password', 'signature']]
    static belongsTo = [person: Person]
    static constraints = {
        username size: 6..25,  unique: true, nullable: false
        password blank: false, nullable: false, minSize: 6
        signature minSize: 6, blank: false
        person nullable: false
    }
    String getDisplayString(){
        return username
    }
    @Override
    int hashCode() {
        username?.hashCode() ?: 0
    }

    @Override
    boolean equals(other) {
        is(other) || (other instanceof User && other.username == username)
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    Set<RoleGroup> getAuthorities() {
        UserRoleGroup.findAllByUser(this)*.roleGroup
    }

    def onSave = {
        // may optionally refer to newState map
    }
    def onDelete = {
        println "User $username was deleted"
        // may optionally refer to oldState map
    }
    def onChange = { oldMap, newMap ->
        println "User $username was changed ..."
        oldMap.each({ key, oldVal ->
            //noinspection GroovyAssignabilityCheck,GroovyAssignabilityCheck
            if (oldVal != newMap[key]) {
                println " * $key changed from $oldVal to " + newMap[key] + " for " + username
            }
        })
    }

    String toString() {
        getDisplayString()
    }

    def resetFalsePasswordCount() {
        falsePasswordCount = 0
    }

    def incrementFalsePasswordCount() {
        falsePasswordCount++
        if (falsePasswordCount >= 3) lockAccount()
    }

    def lockAccount() {
        accountLocked = true
    }


}

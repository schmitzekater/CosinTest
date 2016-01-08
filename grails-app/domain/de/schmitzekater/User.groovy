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
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false

    User(String username, String password, String signature){
        this()
        this.username = username
        this.password = password
        this.signature = signature
    }
    User(String username, String password, String signature, Person person){
        this()
        this.username = username
        this.password = password
        this.signature = signature
        this.person = person
    }

    static transients = ['springSecurityService']
    /*static mapping = {
        table: '`user`'
        password column: '`password`'
    }*/
    static auditable = true
    static belongsTo = [person: Person]
    static constraints = {
        username size: 6..25,  unique: true, nullable: false
        password blank: false, nullable: false
        signature size: 6..30, blank: false
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
        println "Before Insert"
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        println "Encode password"
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    Set<RoleGroup> getAuthorities() {
        UserRoleGroup.findAllByUser(this)*.roleGroup
    }

    def onSave = {
        println "Inserting new User $username, ($password, $signature, $person.firstName, $person.lastName"
        // may optionally refer to newState map
    }
    def onDelete = {
        println "User $username was deleted"
        // may optionally refer to oldState map
    }
    def onChange = { oldMap, newMap ->
        println "User $username was changed ..."
        oldMap.each({ key, oldVal ->
            if (oldVal != newMap[key]) {
                println " * $key changed from $oldVal to " + newMap[key] + " for " + username
            }
        })
    }

    String toString() {
        getDisplayString()
    }


}

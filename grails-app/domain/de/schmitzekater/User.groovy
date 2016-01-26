package de.schmitzekater

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.util.regex.Matcher

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable{

    private static final long serialVersionUID = 1
    transient springSecurityService
    String username
    String password
    String signature
    Date passwordChangeDate
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    int falsePasswordCount = 0


    User(String username, String password, String signature, Person person, Date passwordChangeDate){
        //noinspection GroovyAssignabilityCheck
        this()
        this.username = username
        this.password = password
        this.signature = signature
        this.person = person
        this.passwordChangeDate = passwordChangeDate
    }

    static transients = ['springSecurityService']

    static auditable = [mask: ['password', 'signature']]
    static belongsTo = [person: Person]
    static constraints = {
        username size: 6..25,  unique: true, nullable: false
        password blank: false, nullable: false, minSize: 6, validator: { pwd ->
            def matchSmall = pwd =~ /(?=[A-Z])/           // Password needs to have a Capital
            def matchCapital = pwd =~ /[a-z]/               // Password needs a small letter
            def matchNumeric = pwd =~ /[0-9]/               // Password needs a number
            return (matchSmall && matchCapital && matchNumeric)
        }
        passwordChangeDate nullable: true
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
        if(!passwordChangeDate) passwordChangeDate = new Date()
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
        log.warn("User $username was deleted")
        // may optionally refer to oldState map
    }
    def onChange = { oldMap, newMap ->
        log.info("User $username was changed ...")
        oldMap.each({ key, oldVal ->
            //noinspection GroovyAssignabilityCheck,GroovyAssignabilityCheck
            if (oldVal != newMap[key]) {
                log.info(" * $key changed from $oldVal to " + newMap[key] + " for " + username)
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

    boolean isPasswordExpired() {
        passwordExpired
    }

    boolean isAccountLocked() {
        accountLocked
    }


}

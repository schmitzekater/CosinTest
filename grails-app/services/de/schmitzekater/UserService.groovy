package de.schmitzekater

import grails.transaction.Transactional
import org.apache.log4j.Logger
import org.springframework.validation.Errors

import javax.xml.bind.ValidationException

class UserException extends RuntimeException {
    String message
    User user
}

class UserValidationException extends RuntimeException {
    String message
    Errors errors
}

@Transactional
class UserService {

    /**
     *
 * @param username          Username
     * @param password      Password
     * @param signature     Signature
     * @param per           Person for the new user
     * @return false if user not created, new user if successful
     */
    def createUser(String username, String password, String signature, Person per) {
        def user = new User(username, password, signature, per, new Date())
        if (!user.validate()){
            return false
        }
        else {
            if(!user.save()){
                log.error("Could not create user $user in UserService")
                throw new UserException(message: "Ungültiger User", user: user)
            }
            else{
                return user
            }
        }
    }

    /**
     *
     * @param user Existing User
     * @param rg    Exting RoleGroup
     * @return N/A
     */
    def addUserToGroup(User user, RoleGroup rg){
            /* Add the new Role */
            def success = UserRoleGroup.create user, rg, true
        if(success){
            log.info("Added ${user.username} to group ${rg.displayString}")
        }
        else{
            log.error("Could not add ${user.username} to group ${rg.getDisplayString()}")
            throw new UserException(message: "Error addind user to Usergroup", user: user)
        }
    }

    def failedLogin(String username) {
        /*
        After unsuccessful login the false password counter will be incremented.
         */
        def user = User.findByUsername(username)
        if(user){
            user.incrementFalsePasswordCount()
            user.save()
            log.warn("Unsuccessful login attempt from $user.username")
        }
        else{
            def message = "User tried to log on: $username"
            log.error(message)
            /**
             * This would be a good part to count login-tries with different names to prevent DOS-attacks and block IPs
              */
        }
    }

    def successfulLogin(String username) {
        /*
        After successful login the false password counter will be reset
         */
        log.info("Successful login for $username im Service")
        def user = User.findByUsername(username)
        if (user) {
            user.resetFalsePasswordCount()
            user.save()
            log.info("Successful login attempt from $user.username")
        } else {
            log.error("How the hell could $username log in and not be in the database????")
        }
    }

    def updateUserGroup(User user, RoleGroup roleGroup) {
        /* Delete User from his old role(s). */
        UserRoleGroup.removeAll(user, true)
        /* Add the new Role */
        UserRoleGroup.create user, roleGroup, true
    }

    def updatePassword(User user, String password_new) {
        user.password = password_new
        user.passwordExpired = false
        user.passwordChangeDate = new Date()
        return user.save()
    }

    /*
    Resets the users password and unlocks him.
    Password will be expired, so that the user has to change upon login
     */
    def changeUserPassword(User user, String password_new) {
        user.passwordChangeDate = new Date()
        user.accountExpired = false
        user.accountLocked = false
        user.passwordExpired = true
        user.enabled = true
        user.password = password_new
        return user.save()
    }

    User lockUser(User user) {
        user.accountLocked = true
        return user.save()
    }

    User unlockUser(User user) {
        user.accountLocked = false
        return user.save()
    }

    boolean enableUser(User user) {
        user.enabled = true
        return user.save()
    }

    boolean disableUser(User user) {
        user.enabled = false
        return user.save()
    }
}
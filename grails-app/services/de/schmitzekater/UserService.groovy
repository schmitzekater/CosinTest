package de.schmitzekater

import grails.transaction.Transactional
import org.apache.log4j.Logger

class UserException extends RuntimeException {
    String message
    User user
}

@Transactional
class UserService {


    def createUser(String uid, String pwd, String sig, Person per) {
        def user = new User(username: uid, password: pwd, signature: sig, person: per, passwordChangeDate: new Date())
        if (user.validate() && user.save()) return user
        else {
            log.error("Could not create user $uid in UserService")
            throw new UserException(message: "Ungültiger User", user: user)
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
}
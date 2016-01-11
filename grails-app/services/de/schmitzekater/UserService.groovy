package de.schmitzekater

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

class UserException extends RuntimeException {
    String message
    User user
}

@Transactional
class UserService {

    def springSecurityService

    def createUser(String uid, String pwd, String sig, Person per) {
        def user = new User(username: uid, password: pwd, signature: sig, per)
        if (user.validate()) return user
        else throw new UserException(message: "Ungültiger User", user: user)
    }

    def failedLogin(String username) {
        println "Im Service"
        /* def user = User.findByUsername(username)
         user.incrementBadPasswordCount()
         user.save()
         */ springSecurityService.reauthenticate user.username
    }

}

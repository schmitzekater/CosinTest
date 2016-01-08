package de.schmitzekater

import grails.transaction.Transactional

class UserException extends RuntimeException {
    String message
    User user
}

@Transactional
class UserService {

    def createUser(String uid, String pwd, String sig, Person per) {
        def user = new User(username: uid, password: pwd, signature: sig, per)
        if (user.validate()) return user
        else throw new UserException(message: "Ungültiger User", user: user)
    }

}

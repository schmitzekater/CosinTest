package de.schmitzekater

import grails.transaction.Transactional

class UserException extends RuntimeException {
    String message
    User user
}

@Transactional
class UserService {

    def createUser(String userId, String password, String signature, Person per) {
        def user = new User(userId: userId, password: password, signature: signature, per)
        if (user.validate()) return user
        else throw new UserException(message: "Ungültiger User", user: user)
    }

    def serviceMethod() {

    }
}

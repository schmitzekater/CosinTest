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

    def failedLogin(String username) {
        def user = User.findByUsername(username)
        if(user){
            user.incrementFalsePasswordCount()
            user.save()
        }
        else{
            /**
             * This would be a good part to count login-tries with different names to prevent DOS-attacks and block IPs
              */
        }
    }
}
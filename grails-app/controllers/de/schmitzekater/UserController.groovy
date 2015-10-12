package de.schmitzekater

class UserController {
    static scaffold = User
    def index() { }
    def changePassword(User user, String oldPw, String newPw){
        if(oldPw != newPw){
            println("Condition met")
            Date now = new Date()
            user.setPassword(newPw)
            user.setLastPasswordChange(now)

        }
        else {
            println("Error, new Password cannot be the old Password")
            user.setErrors(new Error("Error, new Password cannot be the old Password"))
        }
    }
}

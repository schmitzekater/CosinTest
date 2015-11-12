package de.schmitzekater

import ch.qos.logback.classic.Level
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UserController {
    static scaffold = User
    static defaultAction = "list"

    def userService
    def personService
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

    def list() {
        def users = User.getAll()
        return [users: users, numUser: User.count]
    }

    def createUser(String userId, String password, String signature, Person per) {
        def user
        try {
            user = userService.createUser(userId, password, signature, per)
            flash.message = "Neuen User angelegt: ${user.userId}"
            redirect(action: 'show', params: user.id)
        } catch (UserException ue) {
            flash.message = ue.message
            logger.error(ue.message)
        }

    }
    def register(){
        println "In register"
        if(request.method=="POST"){
            println "Post kam an"
            params.each {key,  value ->
                println "Key " + key + " Value " + value
            }
            def person
            def user
            try{
                person = personService.createPerson(lastName: params.person.lastName, firstName: params.person.firstName, email: params.person.email)
                //person = personService.createPerson(params)
                println "Person drin"
                user = userService.createUser(userId: params.userId, password: params.password, signature: params.signature, Person: person)
                flash.message(message: "default.created.message", args:"['User', params.userId]")
                redirect(action: 'show', params: user.id)
            }
            catch(Exception e){
                    flash.errors = e.message
                  //  logger.error(e.message)
            }
        }


    }

    def update() {

        def user = User.findById(params['id'])

        if (user) {
            def oldUserId = user.userId
            user.properties = params
            if (user.save()) {
                flash.message = message(code: 'default.updated.message', args: ['User', user.userId])
                redirect(action: "list")//, id: params['id'])
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['User', oldUserId])
                redirect(action: "edit", id: params['id'])
            }

        } else {
            //  response.sendError(404)
        }

    }
}

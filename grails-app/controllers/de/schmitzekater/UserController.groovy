package de.schmitzekater

import grails.validation.Validateable

class UserController {
    static scaffold = User
    static defaultAction = "list"

    def userService
    def passwordEncoder
    transient springSecurityService

    def index() {
        redirect action: list(), params: params
    }

    def show(){
        redirect action: 'detail', params: params
    }
    def editPassword(){
        render view: 'editPassword'
    }
    def changeOwnPassword(){
        User user = springSecurityService.isLoggedIn() ? springSecurityService.currentUser : null
        println "Current user $user"
        params.each{ key, value ->
            println "Key $key, Value: $value"
        }
        if(user){
            //Check if old Password is correct
            //CharSequence oldPw = params.oldPw
            //if(passwordEncoder.matches( (oldPw, user.password)){ // THIS IS NOT WORKING! matches expects CharSequence and there is always a String passed !!!!!
                //Check if newPW = newPWRepeat
            def newPw = params.newPw
            def newPwRepeat = params.newPwRepeat
            if(newPw == newPwRepeat){
                println "Checking if the new password is entered correct twice"
               /* //If correct check if oldPW != newPW
                newPw = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(newPw,  user.username) : newPw
                if(newPw != oldPw) // SEE ABOVE; NOT WORKUNG
                {*/
                    println "All good"
                    // If new Password is not the old password save user
                    user.password = newPw
                    user.passwordExpired = false
                    user.save()
                    flash.message = message(code: 'password.updated.message', args: [user.username])
                    redirect action: 'list'
                }
                   /* else{
                        println "Old password used again"
                        // Old Password used
                        user.errors.reject('user.password.oldPw', ['oldPw', 'newPw','class User'] as Object, '[Property [{0}] and propertx{1} of class [{2}] shall not be used twice]')
                        user.errors.rejectValue('newPw', 'user.password.repeatForbid')
                        user.errors.rejectValue('newPwRepeat', 'user.password.repeatForbid')
                    }*/
                //}
                else{
                    println "Password was not entered twice correct"
                    // Password repeat does not match
                    flash.error = message(code: 'error.password.repeat')
                    redirect action: 'editPassword'
                }
            //}
            /*else{
                println "Old password false"
                // Old Password was false
                user.errors.reject('user.password.oldPw', 'Old PW false')
            }*/
        }

    }

    def changeUserPassword(){
        def user = User.get(params.id)
        if(user){
            if(params.newPw == params.newPwRepeat){
                user.accountExpired = false
                user.accountLocked = false
                user.passwordExpired = true
                user.enabled = true
                user.password = params.newPw
                user.save()
                User: user
            }
            else{
                user.errors.reject('user.password.noMatchRepeat', ['newPw', 'class User'] as Object, '[Property [{0}] of class [{1}] does not match confirmation]')
                user.errors.rejectValue('newPw', 'user.password.noMatchRepeat')
            }
        }
    }


    /**
     * Hier kann ein User aus einer bestehenden Person angelegt werden.
     * @return Neuer user
     */

    def createUser() {
        def user
        try {
            user = userService.createUser(params.userId, params.password, params.signature, params.person)
            flash.message = message(code: 'default.created.message', args: ['User', user.username])
            redirect(action: 'show', params: user.id)
        } catch (UserException ue) {
            flash.message = ue.message
            logger.error(ue.message)
        }

    }

    /**
     * register
     * Diese Funktion dient dazu einen neuen User samt Person anzulegen.
     * @param urc die Parameter für User und Person
     * @return user
     */
    def register(UserRegistrationCommand urc) {
        if (urc.hasErrors()) {
            render view: "register", model: [user: urc]
            flash.error = message(code: 'form.errors.entries')
        } else {
            def user = new User(urc.properties)

            user.person = new Person(urc.properties).save()
            if (user.person && user.validate() && user.save()) {

                flash.message = message(code: 'default.created.message', args: ['User', user.username])
                redirect action: "list"
            } else {
                log.debug("User konnt nicht gespeichert werden. Controller User, Action Register")
                return [user: urc]
            }
        }
    }

    /**
     * Auflistung aller user
     * @return List of user
     */
    def list() {
        if(!params.max) params.max = 10
        def users = User.list(params)
        render view:"/layouts/list", model: [model:users, count: User.count]
    }
    /**
     * Detaillierte Ansicht eines users
     * @return Details eines Users
     */
    def detail() {
        def user = User.findById(params.id)
        render view: "/layouts/detail", model: [user: user]
    }

    def update() {
        def user = User.findById(params.id)
        if (user) {
            def oldUserId = user.username
            user.properties = params
            if (user.save()) {
                flash.message = message(code: 'default.updated.message', args: ['User', user.username])
                redirect(action: "detail", id: params['id'])
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['User', oldUserId])
                redirect(action: "edit", id: params['id'])
            }

        } else {
            //  response.sendError(404)
        }

    }
}
/**
 * UserRegistrationCommand
 * Command-Object um einen User und eine Person gleichzeitig zu erstellen.
 */

class UserRegistrationCommand implements Validateable {
    String username
    String password
    String passwordRepeat
    String signature
    String signatureRepeat
    String firstName
    String lastName
    String email

    static constraints = {
        importFrom Person
        importFrom User
        /*
        Password darf nicht gleich dem Usernamen sein.
        Die Signatur darf nicht gleich dem Usernamen sein.
         */
        password  blank: false, nullable: false, validator: { passwd, urc -> return passwd != urc.userId }
        passwordRepeat nullable: false, validator: { passwd2, urc ->
            if (passwd2 != urc.password) {
                return 'user.rejectPassword.noMatch'
            } else return (passwd2 == urc.password)
        }
        signature minSize: 6, blank: false, nullable: false, validator: { sig, urc -> return sig != urc.userId }
        signatureRepeat nullable: false, blank: false, validator: { sig2, urc ->
            if (sig2 != urc.signature) {
                return 'user.rejectSignature.noMatch'
            }
            return sig2 == urc.signature
        }
    }
}
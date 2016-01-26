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

    def lockAccount() {
        def user = User.get(params.id)
        if (user) {
            user.accountLocked = true
            user.save()
            flash.message = message(code: 'user.accountLocked', args: [user.username])
            log.info(flash.message)
            redirect view: '/layouts/list'
        } else {
            flash.error = message(code: "error.generic.error")
            log.error(flash.message)
            redirect view: '/layouts/list'
        }
    }


    def unlockAccount() {
        def user = User.get(params.id)
        if (user) {
            user.accountLocked = false
            user.save()
            flash.message = message(code: 'user.accountUnLocked', args: [user.username])
            log.info(flash.message)
            redirect view: '/layouts/list'
        } else {
            flash.error = message(code: "error.generic.error")
            log.error(flash.message)
            redirect view: '/layouts/list'
        }
    }


    def enableAccount() {
        def user = User.get(params.id)
        if (user) {
            user.enabled = true
            user.save()
            flash.message = message(code: 'user.accountLocked', args: [user.username])
            log.info(flash.message)
            redirect view: '/layouts/list'
        } else {
            flash.error = message(code: "error.generic.error")
            log.error(flash.message)
            redirect view: '/layouts/list'
        }
    }


    def disableAccount() {
        def user = User.get(params.id)
        if (user) {
            user.enabled = false
            user.save()
            flash.message = message(code: 'user.accountLocked', args: [user.username])
            log.info(flash.message)
            redirect view: '/layouts/list'
        } else {
            flash.error = message(code: "error.generic.error")
            log.error(flash.message)
            redirect view: '/layouts/list'
        }
    }


    def changeOwnPassword(){
        User user = springSecurityService.isLoggedIn() ? springSecurityService.currentUser : null

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
                    user.passwordChangeDate = new Date()
                if (user.validate(password: newPw)) {
                    user.save()
                    flash.message = message(code: 'password.updated.message', args: [user.username])
                    log.info(flash.message)
                    redirect action: 'list'
                } else {
                    user.errors.each { k ->
                        println "Error $k"
                    }
                    flash.error = message(code: "user.password.repeatForbid")
                    redirect action: 'editPassword'
                }

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
                log.error(flash.message)
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
    /**
     * This function is used when the admin changes the  password for a user.
     * The password will be set to expired, so that the user has to change it upon logon.
     * @return
     */
    def changeUserPassword(User user) {
        //def user = User.get(params.id)
        if(user){
            if (params.password.equals(params.newPwRepeat)) {
                user.passwordChangeDate = new Date()
                user.accountExpired = false
                user.accountLocked = false
                user.passwordExpired = true
                user.enabled = true
                user.password = params.password
                if (user.validate() && user.save(failOnError: true)) {
                    flash.message = message(code: 'password.updated.message', args: [user.username])
                    log.info(flash.message)
                    redirect view: '/layouts/list'
                } else {
                    flash.error = message(code: 'error.not.updated.message', args: ['User', user.username])
                    log.error(flash.error)
                    render view: 'editUserPassword', model: [user: user]
                }
            }
            else{
                //flash.error = message(code: 'user.rejectPassword.noMatch', args:['User', user.username])
                user.errors.reject('user.rejectPassword.noMatch', 'Password does not match')
                user.errors.rejectValue('password', 'user.rejectPassword.noMatch')
                render view: 'editUserPassword', model: [user: user]
            }
        } else {
            log.error "Error in changeUserPassword for $user.username"
            render view: 'editUserPassword', [user: user]
        }
    }

    def editUserPassword() {
        def user = User.findById(params.id)
        [user: user]
    }
    /**
     * This function is used when a user tries to log on with an expired password
     */
    def passwordExpired() {
        [username: session['SPRING_SECURITY_LAST_USERNAME']]
    }

    def updatePassword(String password, String password_new, String password_new_2) {
        String username = session['SPRING_SECURITY_LAST_USERNAME']
        if (!username) {
            flash.error = 'Sorry, an error has occurred'
            log.error(flash.error)
            redirect controller: 'login', action: 'auth'
            return
        }
        if (!password || !password_new || !password_new_2 || password_new !=
                password_new_2) {
            flash.error = 'Please enter your current password and a valid new password'
            log.error(flash.error)
            render view: 'passwordExpired', model: [username:
                                                            session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }
        User user = User.findByUsername(username)
        println "Got user $user.username"
        if (!passwordEncoder.isPasswordValid(user.password, password, null /*salt*/)) {
            flash.error = 'Current password is incorrect'
            log.error(flash.error)
            render view: 'passwordExpired', model: [username:
                                                            session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }
        if (passwordEncoder.isPasswordValid(user.password, password_new, null /*salt*/)) {
            flash.error = 'Please choose a different password from your current one'
            log.error(flash.error)
            render view: 'passwordExpired', model: [username:
                                                            session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }
        user.password = password_new
        user.passwordExpired = false
        user.passwordChangeDate = new Date()
        if (user.validate() && user.save(failOnError: true)) {
            flash.message = message(code: 'password.updated.message', args: [user.username])
            log.info(flash.message)
            redirect controller: 'login', action: 'auth', model: [username: user.username, user: user]
        } else {
            flash.error = message(code: 'error.not.updated.message', args: ['User', user.username])
            log.error(flash.error)
            redirect action: 'passwordExpired'
        }

    }

    /**
     * Hier kann ein User aus einer bestehenden Person angelegt werden.
     * @return Neuer user
     */
    def createUser() {
        log.info("createUser() called")
        def user
        def person
        if(params.person && params.person!='null'){
            person = Person.findById(params.person)
        }
        else {
            flash.error = 'Person must be selected!'
            log.error(flash.error)
            redirect action: 'create', params: params
        }
        user = new User(username: params.username, password: params.password, signature: params.signature, person: person)
        if(user.validate() & user.save()) {
            def roleGroup = RoleGroup.findById(params.userRoleGroup)
            if (roleGroup) {
                /* Add the new Role */
                UserRoleGroup.create user, roleGroup, true
            }
            flash.message = message(code: 'default.created.message', args: ['User', user.username])
            log.info(flash.message)

            redirect action: 'show', id: user.id
        }
        else{
            flash.error = message(code: 'default.not.created.message', args: ['User', user.username])
            log.error(flash.error)
            respond user.errors, view: 'create'
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
                def roleGroup = RoleGroup.findById(params.userRoleGroup)
                if (roleGroup) {
                    /* Add the new Role */
                    UserRoleGroup.create user, roleGroup, true
                }

                flash.message = message(code: 'default.created.message', args: ['User', user.username])
                log.info(flash.message)
                redirect action: "list"
            } else {
                log.error("User konnt nicht gespeichert werden. Controller User, Action Register")
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
            def roleGroup = RoleGroup.findById(params.userRoleGroup)
            if (roleGroup) {
                /* Delete User from his role(s). */
                UserRoleGroup.removeAll(user, true)
                /* Add the new Role */
                UserRoleGroup.create user, roleGroup, true
            }
            def oldUserId = user.username
            user.properties = params
            if (user.save()) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label'), user.username])
                log.info(flash.message)
                redirect(action: "detail", id: params['id'])
            } else {
                flash.error = message(code: 'error.not.updated.message', args: ['User', oldUserId])
                log.error(flash.error)
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
    Date passwordChangeDate = new Date()

    static constraints = {
        importFrom Person
        importFrom User
        /*
        Password darf nicht gleich dem Usernamen sein.
        Die Signatur darf nicht gleich dem Usernamen sein.
         */
        password  blank: false, nullable: false, validator: { passwd, urc -> return passwd != urc.username }
        passwordRepeat nullable: false, validator: { passwd2, urc ->
            if (passwd2 != urc.password) {
                return 'user.rejectPassword.noMatch'
            } else return (passwd2 == urc.password)
        }
        signature minSize: 6, blank: false, nullable: false, validator: { sig, urc -> return sig != urc.username }
        signatureRepeat nullable: false, blank: false, validator: { sig2, urc ->
            if (sig2 != urc.signature) {
                return 'user.rejectSignature.noMatch'
            }
            return sig2 == urc.signature
        }
    }
}
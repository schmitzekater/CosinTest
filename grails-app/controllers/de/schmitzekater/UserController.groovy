package de.schmitzekater

import grails.validation.Validateable

/**
 * @author Burt Beckwith
 * @author Alexander Schmitz (extended the template from source)
 *
 * Source: http://grails-plugins.github.io/grails-spring-security-core/v3/index.html#personClass
 *
 * Controller for the Domain class User
 */
class UserController {
    static scaffold = User
    static defaultAction = "list"

    def userService             /** Dependency Injection for the UserService    */
    def personService           /** Dependency Injection for the PersonService  */
    def passwordEncoder
    transient springSecurityService

    def index() {
        redirect action: list(), params: params
    }

    def show(){
        redirect action: 'detail', params: params
    }

    /*
    render the view to edit the Password
     */
    def editPassword(){
        render view: 'editPassword'
    }

    def registerUser(){
        respond new UserRegistrationCommand()
    }
    /*
    Method to lock an User
    TODO: Refactor to Service
     */
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

    /*
     Method to unlock an User
    TODO: Refactor to Service
   */
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

    /*
    Method to enable an User
    TODO: Refactor to Service
   */
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

    /*
      Method to disable an User
      TODO: Refactor to Service
       */
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

    /*
    Method for the user to edit his password
    Get's the principal from the current logge-in User
    TODO: Refactor Password-Checking
     */
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
    /*
     * This function is used when the admin changes the  password for a user.
     * The password will be set to expired, so that the user has to change it upon logon.
     * TODO: Refactor to Service!
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

    /*
    View for the Admin if a password from an user must be edited
     */
    def editUserPassword() {
        def user = User.findById(params.id)
        [user: user]
    }
    /*
     * Render view when user with an expired password try to log on
     */
    def passwordExpired() {
        [username: session['SPRING_SECURITY_LAST_USERNAME']]
    }

    /*
    Method to save the new password
    TODO: Refactor to Service!
     */
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

    /*
     * Method to create a new User (with existing Person!).
     * @return new User
     */
    def createUser() {
        def person = Person.findById(params.person)
        def user = userService.createUser(params.username, params.password, params.signature, person)
        if(user) {
            def group = RoleGroup.findById(params.userRoleGroup)
            userService.addUserToGroup(user, group)
            flash.message = message(code: 'default.created.message', args: ['User', user.username])
            redirect action: 'detail', id: user.id
        }
        else{
            flash.error = message(code: 'default.not.created.message', args: ['User', user.username])
            respond user.errors, view: 'create'
        }

    }

    /**
     * Method to register a new User and a new Person simultaniously
     * @param urc with params for User and Person
     * @return user
     * TODO: Create extra view (to avoid errors upon initial load! respond new UserRegistrationCommand)
     * TODO: Refactor to Service
     */
    def register(UserRegistrationCommand urc) {
        if (urc.hasErrors()) {
            render view: "registerUser", model: [user: urc]
            flash.error = message(code: 'form.errors.entries')
        } else {
            //create a new Person instance and save it
            def person = personService.createPerson(urc.lastName, urc.firstName, urc.email)
            // create a new User instance
            def user = userService.createUser(urc.username, urc.password, urc.signature, person)
            if (user) {
                /* Find the group that is selected for the user */
                def roleGroup = RoleGroup.findById(params.userRoleGroup)
                userService.addUserToGroup(user, roleGroup)
                flash.message = message(code: 'default.created.message', args: ['User', user.username])
                log.info(flash.message)
                redirect action: "list"
            } else {
                log.error("User could not be saved")
                redirect view: 'registerUser', userRegistrationCommand: urc
            }
        }
    }

    /*
     * Tabular view of all Users
     */
    def list() {
        if(!params.max) params.max = 10
        def users = User.list(params)
        render view:"/layouts/list", model: [model:users, count: User.count]
    }
    /*
     * Detailed view of one User
     **/
    def detail() {
        def user = User.findById(params.id)
        render view: "/layouts/detail", model: [user: user]
    }

    /*
    Method to save an updated User
    TODO: Refactor to Service!
     */
    def update(User user) {
        def roleGroup = RoleGroup.findById(params.userRoleGroup)
        if (roleGroup) {
            userService.updateUserGroup(user, roleGroup)
        }
        user.properties = params
        if (user.save()) {
            flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label'), user.username])
            log.info(flash.message)
            redirect(action: "detail", id: params['id'])
        } else {
            flash.error = message(code: 'error.not.updated.message', args: ['User', user.username])
            log.error(flash.error)
            redirect(action: "edit", id: params['id'])
        }
    }



    def handleUserException(UserException ue){
        flash.error = ue.message
        redirect view: '/error', exception: ue
    }
    def handlePersonrException(PersonException pe){
        flash.error = pe.message
        redirect view: '/error', exception: pe
    }
}
/**
 * UserRegistrationCommand
 * Command-Object that stores properties of an User and a Person
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
        Password must not be the username!
        Signature must not be the username!
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
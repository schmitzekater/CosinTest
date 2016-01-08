package de.schmitzekater

import grails.validation.Validateable
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_READ')
class UserController {
    static scaffold = User
    static defaultAction = "list"

    def userService

    @Secured('ROLE_READ')
    def index() {
        redirect action: list(), params: params
    }

    @Secured('ROLE_READ')
    def show(){
        redirect action: 'detail', params: params
    }
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

    /**
     * Hier kann ein User aus einer bestehenden Person angelegt werden.
     * @return Neuer user
     */

    @Secured('ROLE_CREATE')
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
    @Secured('ROLE_ADMIN')
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
    @Secured('ROLE_READ')
    def list() {
        if(!params.max) params.max = 10
        def users = User.list(params)
        render view:"/layouts/list", model: [model:users, count: User.count]
    }
    /**
     * Detaillierte Ansicht eines users
     * @return Details eines Users
     */
    @Secured('ROLE_READ')
    def detail() {
        def user = User.findById(params.id)
        render view: "/layouts/detail", model: [user: user]
    }

    @Secured('ROLE_EDIT')
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

@Secured('ROLE_READ')
class UserRegistrationCommand implements Validateable {
    String userId
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
        signature size: 6..30, blank: false, nullable: false, validator: { sig, urc -> return sig != urc.userId }
        signatureRepeat nullable: false, blank: false, validator: { sig2, urc ->
            if (sig2 != urc.signature) {
                return 'user.rejectSignature.noMatch'
            }
            return sig2 == urc.signature
        }
    }
}
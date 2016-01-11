package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import de.schmitzekater.UserService

@Transactional
class CosinSecurityEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    def userService

    @Override
    void onApplicationEvent(AuthenticationSuccessEvent event) {
        println "Listener, source: " + event.getSource()
        println "Listener, text: " + event.toString()
        def principal = event.getSource().getPrincipal()
        String username = principal.username
        println "Username $username"
        try {
            println "Im Try"
            userService.failedLogin(username)
        } catch (Exception e) {
            println "Error " + e.getCause()
        }
    }
}

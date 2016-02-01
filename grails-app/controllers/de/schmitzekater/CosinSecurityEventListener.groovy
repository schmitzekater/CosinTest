package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import de.schmitzekater.UserService

/**
 * Listener that can be used to handle Login events.
 * Currently implemented in appplication.groovy via grails.plugin.springsecurity.<EVENT>
 *     TODO: Handle all events within this listener. (SoC)
 */

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

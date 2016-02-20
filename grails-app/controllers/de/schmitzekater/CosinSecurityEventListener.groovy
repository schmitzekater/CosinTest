package de.schmitzekater

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent

import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent


/**
 * Listener that can be used to handle Login events.
 *
 * This Listener reacts on ApplicationEvents, mainly Security Events.
 *     DONE: Handle all events within this listener. (SoC)
 */

class CosinSecurityEventListener implements ApplicationListener<ApplicationEvent> {

    def userService

    @Override
    void onApplicationEvent(ApplicationEvent event) {
        // react to Security Events
        if (event instanceof InteractiveAuthenticationSuccessEvent) handleInteractiveAuthenticationSuccessEvent(event)
        if (event instanceof AbstractAuthenticationFailureEvent) handleAbstractAuthenticationFailureEvent(event)
        if (event instanceof AuthenticationSuccessEvent) handleAuthenticationSuccessEvent(event)
        if (event instanceof AuthenticationSwitchUserEvent) handleAuthenticationSwitchUserEvent(event)
    }


    void handleInteractiveAuthenticationSuccessEvent(InteractiveAuthenticationSuccessEvent event) {
        // Fired upon successful login events
        // Resets the false password counter
        def user
        def source = event.getSource()
        def principal = source.getPrincipal()
        if (principal instanceof GrailsUser) {
            user = principal.getUsername()
        }
        if (user) {
            userService.successfulLogin(user)
        }
    }

    void handleAbstractAuthenticationFailureEvent(AbstractAuthenticationFailureEvent event) {
        // Fired on unsuccesful login events
        // If the username is found in the database the false Password counter will be incremented
        def source = event.getSource()
        def user = source.getPrincipal()
        if (user) {
            if (event instanceof AuthenticationFailureBadCredentialsEvent)
                userService.failedLogin(user)
        }
    }


    void handleAuthenticationSuccessEvent(AuthenticationSuccessEvent event) {
        // handle AuthenticationSuccessEvent
        // is intially fired before the Authentication is registered

    }

    void handleAuthenticationSwitchUserEvent(AuthenticationSwitchUserEvent event) {
        // Fired on switched user events. Not used in the application
    }

}

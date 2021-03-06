import de.schmitzekater.User
import de.schmitzekater.UserService
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent

/**
 * Application-wide settings, additional to the application.yml file
 * Handles access to sites and methods (via intercepUrlMap)
 * Calls functions upon (un)successful login attempts
 * TODO: Maybe annotate the controllers with @Secured instead of interceptUrlMap
 *
 */
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.schmitzekater.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.schmitzekater.UserRole'
grails.plugin.springsecurity.authority.className = 'de.schmitzekater.Role'
grails.plugin.springsecurity.authority.groupAuthorityNameField = 'authorities'
grails.plugin.springsecurity.useSecurityEventListener = true		// CosinSecurityEventListener is implemented
grails.plugin.springsecurity.useRoleGroups = true					// User Groups to give access rights to users
grails.plugin.springsecurity.apf.storeLastUsername = true           // Store the credentials even on failed login
grails.plugin.springsecurity.adh.errorPage = '/login/denied'        // Access denied Page
grails.plugin.springsecurity.logout.postOnly = false				// No Method restriction for logout
grails.plugin.springsecurity.logout.afterLogoutUrl = '/login'		// Redirect to Login Page after Logout
grails.plugin.springsecurity.rejectIfNoRule = true					// Block any URL that is not permitted
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap" // use the following map to secure actions. Refactor to Controller-Annotations in the future
grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/', access: ['permitAll']],
		[pattern: '/error', access: ['permitAll']],
		[pattern: '/dbconsole/**', access: ['permitAll']],
		[pattern: '/index', access: ['permitAll']],
		[pattern: '/_index.gsp', access: ['permitAll']],
		[pattern: '/shutdown', access: ['permitAll']],
		[pattern: '/assets/**', access: ['permitAll']],
		[pattern: '/**/js/**', access: ['permitAll']],
		[pattern: '/**/css/**', access: ['permitAll']],
		[pattern: '/**/images/**', access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/login', access: ['permitAll']],
		[pattern: '/login/**', access: ['permitAll']],
		[pattern: '/logout', access: ['permitAll']],
		[pattern: '/logout/**', access: ['permitAll']],
		[pattern: '/common/**', access: ['permitAll']],
		[pattern: '/auditLogEvent/**', access: ['permitAll']],
		[pattern: '/user/editPassword/**', access: ['isAuthenticated()']],
		[pattern: '/user/passwordExpired', access: ['permitAll']],
		[pattern: '/user/passwordExpired/**', access: ['permitAll']],
		[pattern: '/user/updatePassword', access: ['permitAll']],
		[pattern: '/user/updatePassword/**', access: ['permitAll']],
		[pattern: '/user/accountLocked/**', access: ['permitAll']],
		[pattern: '/user/accountExpired/**', access: ['permitAll']],
		[pattern: '/user/accountDisabled/**', access: ['permitAll']],
		[pattern: '/user/userLocked/**', access: ['permitAll']],
		[pattern: '/user/update/**', access: ['permitAll']], 												// Needed to update the own password!
		[pattern: '/user/**', access: ['ROLE_DELETE']],
		[pattern: '/config/index', access: ['permitAll']],
		[pattern: '/config/**', access: ['permitAll']],
		[pattern: '/config/config/**', access: ['ROLE_DELETE']],
		[pattern: '/**/create/**', access: ['ROLE_CREATE']],
		[pattern: '/person/createPerson/**', access: ['ROLE_CREATE']],
		[pattern: '/**/edit/**', access: ["hasAnyRole('ROLE_EDIT,ROLE_DELETE')"]],
		[pattern: '/**/update/**', access: ["hasAnyRole('ROLE_CREATE,ROLE_EDIT,ROLE_DELETE')"]],
		[pattern: '/**/save/**', access: ["hasAnyRole('ROLE_CREATE,ROLE_EDIT,ROLE_DELETE')"]],
		[pattern: '/**/show/**', access: ['permitAll']],
		[pattern: '/**/list/**', access: ['permitAll']],
		[pattern: '/**/createSystemReport/**', access: ['permitAll']],                                    // Watch out!!
		[pattern: '/module/listAllModuleQualifications/**', access: ['permitAll']],
		[pattern: '/software/listAllSoftwareQualifications/**', access: ['permitAll']],
		[pattern: '/module/listAllModuleCalibrations/**', access: ['permitAll']],
		[pattern: '/**/addQualificationToObject/**', access: ["hasAnyRole('ROLE_EDIT,ROLE_CREATE,ROLE_DELETE')"]],
		[pattern: '/**/detail/**', access: ['permitAll']],
		[pattern: '/**/index/**', access: ['permitAll']],
		[pattern: '/**/listActiveSystems/**', access: ['permitAll']],
		[pattern: '/**/listInactiveSystems/**', access: ['permitAll']],
		[pattern: '/**/common/**', access: ['permitAll']],
		[pattern: '/common/**', access: ['permitAll']],
		[pattern: '/common/en/**', access: ['permitAll']],
		[pattern: '/common/de/**', access: ['permitAll']],
		[pattern: '/**/addQualification/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/saveAttachment', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/addSoftware/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/addSoftwareToComputer/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/addSoftwareToSystem/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/addModuleToUnit/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/removeSoftwareFromComputer/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/removeSoftware/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addComputer/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/addComputerToSystem/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/removeComputer/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addModule/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/removeModule/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addUnit/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addUnitToSystem/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/removeUnit/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/system/retireSystem/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/system/retire/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/system/editDataFlow/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE', 'ROLE_CREATE')"]],
		[pattern: '/system/editDataFlowFile/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE', 'ROLE_CREATE')"]]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.failureHandler.exceptionMappings = [
		[exception: LockedException.name, url: '/user/accountLocked'],
		[exception: DisabledException.name, url: '/user/accountDisabled'],
		[exception: AccountExpiredException.name, url: '/user/accountExpired'],
		[exception: CredentialsExpiredException.name, url: '/user/passwordExpired']
]
/*
*//**
 * Security Event Handling
 * DONE: Extract those calls into extra Service or Listener -> CosinSecurityEventListener
 *//*
grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->
	// Fired when a user has successful logged on an the Authorization principal is available
	// The user is looked up in the database and the false password counter will be reset.
	def user
	def userService = appCtx.getBean('userService')
	def source = e.getSource()
	def principal = source.getPrincipal()
	if (principal instanceof GrailsUser) {
		user = principal.getUsername()
	}
	if (user) {
		userService.successfulLogin(user)
	}
}
grails.plugin.springsecurity.onAbstractAuthenticationFailureEvent = { e, appCtx ->
	// Fired on unsuccesful login events
	// If the username is found in the database the false Password counter will be incremented
	def userService = appCtx.getBean('userService')
	def source = e.getSource()
	def user = source.getPrincipal()
	if(user){
		if (e instanceof AuthenticationFailureBadCredentialsEvent)
			userService.failedLogin(user)
	}

}
grails.plugin.springsecurity.onAuthenticationSuccessEvent = { e, appCtx ->
	// handle AuthenticationSuccessEvent
	// is intially fired before the Authentication is registered

}
grails.plugin.springsecurity.onAuthenticationSwitchUserEvent = { e, appCtx ->
	// Fired on switched user events. Not used in the application
}
grails.plugin.springsecurity.onAuthorizationEvent = { e, appCtx ->
	// Not used in the application
}*/

/**
 * Audit Log configuration
 */

grails{
	plugin{
		auditLog{
			auditDomainClassName = 'de.schmitzekater.AuditLogEvent'
			stampEnabled = false
			actorClosure = { request, session -> request.applicationContext.springSecurityService.currentUser }
			logIds = true
			verbose = false
			TRUNCATE_LENGTH = 500
			largeValueColumnTypes = true //needed for TRUNCATE_LENGTH>255
		}
	}
}


import de.schmitzekater.User
import de.schmitzekater.UserService
import grails.plugin.springsecurity.SpringSecurityUtils

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.schmitzekater.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.schmitzekater.UserRole'
grails.plugin.springsecurity.authority.className = 'de.schmitzekater.Role'
grails.plugin.springsecurity.authority.groupAuthorityNameField = 'authorities'
grails.plugin.springsecurity.useSecurityEventListener = true
grails.plugin.springsecurity.useRoleGroups = true
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.rejectIfNoRule = true					// Block any URL that is not permitted
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap" // use the following map to secure actions
grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/', access: ['permitAll']],
		[pattern: '/error', access: ['permitAll']],
		[pattern: '/dbconsole/**', access: ['permitAll']],
		[pattern: '/index', access: ['permitAll']],
		[pattern: '/index.gsp', access: ['permitAll']],
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
		[pattern: '/auditLogEvent/**', access: ['permitAll']],
		[pattern: '/user/editPassword**', access: ['isAuthenticated()']],
		[pattern: '/user/**', access: ['ROLE_DELETE']],
		[pattern: '/config/**', access: ['ROLE_DELETE']],
		[pattern: '/**/create/**', access: ['ROLE_CREATE']],
		[pattern: '/person/createPerson/**', access: ['ROLE_CREATE']],
		[pattern: '/**/edit/**', access: ['ROLE_EDIT']],
		[pattern: '/**/update/**', access: ['ROLE_EDIT']],
		[pattern: '/**/save/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/show/**', access: ['permitAll']],
		[pattern: '/**/list/**', access: ['permitAll']],
		[pattern: '/**/detail/**', access: ['permitAll']],
		[pattern: '/**/index/**', access: ['permitAll']],
		[pattern: '/**/common/**', access: ['permitAll']],
		[pattern: '/**/addQualification/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/saveAttachment', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/addSoftware/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/removeSoftware/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addComputer/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/removeComputer/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addModule/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
		[pattern: '/**/removeModule/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/addUnit/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
		[pattern: '/**/removeUnit/**', access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],

]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]
/**
 * Security Event Handling
 */
grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->
	// Fired when a user has successful logged on an the Authorization pricipal is available
	println "InteractiveAuthenticationSuccessEvent"
	def userService = appCtx.getBean('userService')
	def source = e.getSource()
	String user = source.getPrincipal()
	println "User: " + user
	if (user) {
		userService.successfulLogin(user)
	}
}
grails.plugin.springsecurity.onAbstractAuthenticationFailureEvent = { e, appCtx ->
	// Fired on unsuccesful login events
	println "AbstractAuthenticationFailureEvent"
	def userService = appCtx.getBean('userService')
	def source = e.getSource()
	String user = source.getPrincipal()
	println "User: "+user
	if(user){
			userService.failedLogin(user)
	}

}
grails.plugin.springsecurity.onAuthenticationSuccessEvent = { e, appCtx ->
	// handle AuthenticationSuccessEvent
	// is intially fired before the Authentication is registered
	println "AuthenticationSuccessEvent"

}
grails.plugin.springsecurity.onAuthenticationSwitchUserEvent = { e, appCtx ->
	// Fired on switched user events. Not used in the application
	println "AuthenticationSwitchUserEvent"
}
grails.plugin.springsecurity.onAuthorizationEvent = { e, appCtx ->
	// Not used in the application
	println "AuthorizationEvent"
}

/**
 * Audit Log configuration
 */

grails {
	plugin {
		auditLog {

			logIds = true
			TRUNCATE_LENGTH = 500
			largeValueColumnTypes = true //needed for TRUNCATE_LENGTH>255
			actorClosure = { request, session ->
				//session.user?.username
				if (request.applicationContext.springSecurityService.principal instanceof String){
                    return request.applicationContext.springSecurityService.principal
                }
                def username = request.applicationContext.springSecurityService.principal?.username
                if (SpringSecurityUtils.isSwitched()){
                    username = SpringSecurityUtils.switchedUserOriginalUsername+" AS "+username
                }
                return username
			}
			stampEnabled = false
			stampAlways = false
		}
	}
}

// Added by the Audit-Logging plugin:


grails.plugin.auditLog.auditDomainClassName = 'de.schmitzekater.AuditLogEvent'
grails.plugin.auditLog.stampEnabled = false
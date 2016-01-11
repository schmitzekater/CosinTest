import de.schmitzekater.User
import grails.plugin.springsecurity.userdetails.GrailsUser

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
	[pattern: '/',               		access: ['permitAll']],
	[pattern: '/error',          		access: ['permitAll']],
	[pattern: '/dbconsole/**',          		access: ['permitAll']],
	[pattern: '/index',          		access: ['permitAll']],
	[pattern: '/index.gsp',      		access: ['permitAll']],
	[pattern: '/shutdown',       		access: ['permitAll']],
	[pattern: '/assets/**',      		access: ['permitAll']],
	[pattern: '/**/js/**',       		access: ['permitAll']],
	[pattern: '/**/css/**',      		access: ['permitAll']],
	[pattern: '/**/images/**',   		access: ['permitAll']],
	[pattern: '/**/favicon.ico', 		access: ['permitAll']],
	[pattern: '/login', 				access: ['permitAll']],
	[pattern: '/login/**', 				access: ['permitAll']],
	[pattern: '/logout', 				access: ['permitAll']],
	[pattern: '/logout/**', 			access: ['permitAll']],
	[pattern: '/user/editPassword', 	access: ['isAuthenticated()']],
	[pattern: '/user/**', 		 		access: ['ROLE_DELETE']],
	[pattern: '/config/**', 	 		access: ['ROLE_DELETE']],
	[pattern: '/**/create',		 		access: ['ROLE_CREATE']],
	[pattern: '/person/createPerson',	access: ['ROLE_CREATE']],
	[pattern: '/**/edit',		 		access: ['ROLE_EDIT']],
	[pattern: '/**/update',				access: ['ROLE_EDIT']],
	[pattern: '/**/show/**',		 	access: ['permitAll']],
	[pattern: '/**/list/**',		 	access: ['permitAll']],
	[pattern: '/**/detail/**',		 	access: ['permitAll']],
	[pattern: '/**/index/**',		 	access: ['permitAll']],
	[pattern: '/**/common/**',		 	access: ['permitAll']],
	[pattern: '/**/addQualification', 	access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
	[pattern: '/**/saveAttachment',		access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
	[pattern: '/**/addSoftware', 		access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
	[pattern: '/**/removeSoftware', 	access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
	[pattern: '/**/addComputer', 		access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
	[pattern: '/**/removeComputer', 	access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
	[pattern: '/**/addModule', 			access: ["hasAnyRole('ROLE_EDIT', 'ROLE_CREATE')"]],
	[pattern: '/**/removeModule', 		access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
	[pattern: '/**/addUnit', 			access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],
	[pattern: '/**/removeUnit', 		access: ["hasAnyRole('ROLE_EDIT', 'ROLE_DELETE')"]],

]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

/*
grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->
	// handle InteractiveAuthenticationSuccessEvent
	println "InteractiveAuthenticationSuccessEvent"
	println "AppCtx: "+appCtx.toString()
	def source = e.getSource()
	def user = source.getPrincipal()
	if(user instanceof GrailsUser){
		println "We have a grails user!!"
		def cosuser = user as User
		if(cosuser){
			println "User $cosuser.username logged on successful"
			cosuser.resetBadPasswordCount()
		}
	}
	else println "User: $user.toString()"

}
grails.plugin.springsecurity.onAbstractAuthenticationFailureEvent = { e, appCtx ->
	// handle AbstractAuthenticationFailureEvent
	println "AbstractAuthenticationFailureEvent"
	def source = e.getSource()
	def user = source.getPrincipal()
	if(user instanceof GrailsUser){
		println "User $user.username"
		def cosuser = User.findByUsername(user.username)
		if(cosuser){
			println "User $cosuser.username tried to logon unsuccessful"
			cosuser.incrementBadPasswordCount()
			println "Unsuccessful tries: $cosuser.falsePasswordCount"
		}
	}
}
grails.plugin.springsecurity.onAuthenticationSuccessEvent = { e, appCtx ->
	// handle AuthenticationSuccessEvent
	// is intially fired before the Authentication is registered
	println "AuthenticationSuccessEvent"
}
grails.plugin.springsecurity.onAuthenticationSwitchUserEvent = { e, appCtx ->
    // handle AuthenticationSwitchUserEvent
	println "AuthenticationSwitchUserEvent"
}
grails.plugin.springsecurity.onAuthorizationEvent = { e, appCtx ->
	// handle AuthorizationEvent
	println "AuthorizationEvent"
}
*/


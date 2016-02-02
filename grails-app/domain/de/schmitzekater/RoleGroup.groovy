package de.schmitzekater

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * @author Burt Beckwith
 *
 * source: http://grails-plugins.github.io/grails-spring-security-core/v3/index.html#authorityGroupClass
 *
 * A Rolegroup contains multiple @Roles. User will be assigned to a RoleGroup insted of applying User-specific Roles.
 */
@EqualsAndHashCode(includes='name')
@ToString(includes='name', includeNames=true, includePackage=false)
class RoleGroup implements Serializable {

	private static final long serialVersionUID = 1

	String name
	String displayString

	RoleGroup(String name, String displayString) {
		this()
		this.name = name
		this.displayString = displayString
	}

	Set<Role> getAuthorities() {
		RoleGroupRole.findAllByRoleGroup(this)*.role
	}

	static constraints = {
		name blank: false, unique: true
	}

	static mapping = {
		cache true
	}
}

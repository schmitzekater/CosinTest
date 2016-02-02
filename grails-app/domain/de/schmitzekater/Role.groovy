package de.schmitzekater

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * @author Burt Beckwith
 *
 * source: http://grails-plugins.github.io/grails-spring-security-core/v3/index.html#authorityClass
 * Different Roles that can be applied to a user (access rights)
 * Will not be used directly, instead the Group-Approch is used. (@RoleGroup that an @User can have -> @UserRoleGroup)
 */
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1

	String authority

	Role(String authority) {
		this()
		this.authority = authority
	}

	static constraints = {
		authority blank: false, unique: true
	}

	static mapping = {
		cache true
	}
}

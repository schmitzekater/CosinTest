package de.schmitzekater

/**
 * Created by alexa on 06.01.2016.
 */
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(SystemRole)
@Mock([Computer, System, ComputerRole])
class SystemRoleSpec extends Specification{
    void "Add a computer to a system and assign it a role"(){
        given: "Existing Systems, Computer and ComputerRoles"
        def systemA = new System(systemName: 'System A', area: 'GLP')
        def systemB = new System(systemName: 'System B', area: 'GLP')
        def server = new ComputerRole(role: 'Server')
        def client = new ComputerRole(role: 'Client')
        def computer = new Computer(computerName: 'PCA')

        when: "The computer is added to the systems with roles"
        def roleA = new SystemRole(computer, systemA, server)
        def roleB = new SystemRole(computer, systemB, client)
        roleA.save(failOnError: true)
        roleB.save(failOnError: true)

        then: "The roles are saved and can be retrieved"
        SystemRole.count == 2
        systemA.getComputer().first() == computer
        SystemRole.findAllByComputer(computer).size()==2
        SystemRole.findBySystem(systemA) != null
        def testRole = SystemRole.get(1)
        testRole.computer.computerName.equalsIgnoreCase('PCA')
        testRole.computerRole.getDisplayString().equalsIgnoreCase('Server')

    }

}

package de.schmitzekater

import grails.gorm.DetachedCriteria

/**
 * Created by alexa on 06.01.2016.
 * @author Alexander Schmitz
 *
 * Inspired hy Spring security core plugin (http://grails-plugins.github.io/grails-spring-security-core/v3/index.html#introduction)
 */
class SystemRole implements Serializable{
    private static final long serialVersionUID = 1
    Computer computer
    System system
    ComputerRole computerRole

    //TODO: Make it working! Spring-Security just checks for system & computer. But then no 2 computer can be added to the system
  /*  static constraints = {
        system validator: { System s, SystemRole sr , ComputerRole cr->
            if(sr.computer == null || sr.computer.id == null) return
            boolean existing = false
            SystemRole.withNewSession {
                existing = SystemRole.exists(sr.system.id, s.id, cr.id)
            }
            if(existing) {
                return 'systemRole.exists'
            }
        }
    }*/
    static mapping = {
        id composite: ['system', 'computer', 'computerRole']
    }

    /*
    Specifies the ComputerRole of a Computer within that System
    A Computer can have multiple Roles inside a System and can belong to multiple Systems.
    Example: An office Client that is used for multiple Systems.
    Example2: A server that has multiple Roles inside the System (Database & ApplicationServer)
     */
    SystemRole(Computer c, System s, ComputerRole cr){
        this()
        computer = c
        system = s
        computerRole = cr
    }

    static SystemRole get(long computerId, long systemId){
        criteriaFor(computerId, systemId).get()
    }

    static boolean exists(long computerId, long systemId, long computerRoleId){
        //log.info "Computer: $computerId, System: $systemId, Computer Role: $computerRoleId"
        criteriaFor(computerId, systemId, computerRoleId).count()
    }

    static SystemRole create(Computer computer, System system, ComputerRole cr, boolean flush = false){
        def instance = new SystemRole(computer: computer, system: system, computerRole: cr)
        instance.save(flush: flush, insert: true)
        instance
    }
    static boolean remove(Computer c, System s, boolean flush = false){
        if(c == null || s == null) return false
        int rowCount = SystemRole.where{ computer == c && system == s}.deleteAll()
        if (flush) { SystemRole.withSession {it.flush()}}
        rowCount
    }

    private static DetachedCriteria criteriaFor(long computerId , long systemId , long computerRoleId){
        SystemRole.where{
            computer == Computer.load(computerId) &&
                    system == System.load(systemId) &&
                        computerRole == ComputerRole.load(computerRoleId)
        }
    }
    //Override
    private static DetachedCriteria criteriaFor(long computerId , long systemId){
        SystemRole.where{
            computer == Computer.load(computerId) &&
                    system == System.load(systemId)
        }
    }


}

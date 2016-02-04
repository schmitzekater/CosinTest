package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartHttpServletRequest

import java.text.SimpleDateFormat

/**
 * @author Alexander Schmitz
 * Service to handle the @System domain class.
 */

@Transactional
class SystemService {

    def fileHandleService           /** dependency Injection for the fileHandleService      */

    /**
     *
     * @param system        The system for which the dataflow should be edited
     * @param request       The request that contains the File for upload
     * @return              Path and Name of the stored file.
     */
    def editSystemDataflowFile(System system, MultipartHttpServletRequest request) {
        File dataFlow = fileHandleService.uploadDataflowFile(request, system)
        if (dataFlow) {
            if (system.dataFlow) {
                // Delete the existing dataflow file.
                // User gets a warning displayed before a new upload.
                if (fileHandleService.deleteDataflowFile(system.dataFlow)) {
                    log.info("Deleted old dataflow file $system.dataFlow from System $system.systemName.")
                } else {
                    log.error("Could not delete old dataflow file from System $system.systemName")
                }
            }
            // Set the new dataflow File
            system.setDataFlow(dataFlow)
            if (system.save(failOnError: true)) {
                return dataFlow.name
            }
        }
    }

    /**
     *
     * @param system the    system that will be retired
     * @param retireDate    The Date wwhen the system shall be retired.
     * @return              boolean=true if retired.
     */
    def retireSystem(System system, String retireDate) {
        def sdf = new SimpleDateFormat('yyyy-mm-dd')
        Date date = sdf.parse(retireDate)
        log.info("Retirement date: $date")
        system.clearErrors()
        // Date is not accepted otherwise. Solution: http://stackoverflow.com/questions/14847441/grails-date-is-being-accepted-as-string    Strange....
        system.setIsActive(false)
        system.retirementDate = date
        return (system.save(failOnError: true))
    }

    /**
     * Method to retrieve Systems in a list, divided by the status "isActive"
     * @param params Map of params from the request
     * @param active Defines if active (true) or inactive (false) Systems are returned
     * @return  List<System>
     */
    def getSystemList(Map params, boolean active){
        if (!params.max) params.max = 10
        if (!params.orderBy) params.order = 'asc'
        if (!params.sortBy) params.order = 'systemName'
        def s = System.createCriteria()
        List systemList = s.list(max: params.max, offset: params.offset) {
            eq("isActive", active)
        }
        systemList
    }

    /**
     * Method to set actual Owners of the system
     * @param system    The System
     * @param params    Needs to contain the systemOwners and processOwners to be set
     * @return          boolean=true if all went well
     */
    def updateOwnerShip(System system, Map params){
        /* Update System Ownership */
        def systemOwners = params.systemOwner
        def processOwners = params.processOwner
        if (systemOwners) {
            def presentSystemOwners = system.systemOwner.collect()
            for (so in presentSystemOwners) {
                if (!systemOwners.contains(so.id.toString())) {
                    /* Delete to old Owners */
                    system.removeFromSystemOwner(so)
                    log.info("Removed ${so.getDisplayString()} as SystemOwner from ${system.getDisplayString()}")
                }
            }
            systemOwners.each {
                def person = Person.get(it)
                /* Add the new Owners */
                system.addToSystemOwner(person)
                log.info("Added ${person.getDisplayString()} as SystemOwner to System ${system.getDisplayString()}")
            }
        }
        /* Update Process Ownership */
        if (processOwners) {
            def presentProcessOwners = system.processOwner.collect()
            for (po in presentProcessOwners) {
                if (!processOwners.contains(po.id.toString())) {
                    /* Delete to old Owners */
                    system.removeFromProcessOwner(po)
                    log.info("Removed ${po.getDisplayString()} as ProcessOwner from ${system.getDisplayString()}")
                }
            }
            for (po in processOwners) {
                def person = Person.get(po)
                /* Add the new Owners */
                system.addToProcessOwner(person)
                log.info("Added ${person.getDisplayString()} as ProcessOwner to System ${system.getDisplayString()}")
            }
        }
        return system.save(failOnError: true)
    }

}

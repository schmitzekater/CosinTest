package de.schmitzekater

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartHttpServletRequest

@Transactional
class SystemService {

    def fileHandleService           /** dependency Injection for the fileHandleService      */


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

    def retireSystem(System system, Date date) {
        log.info("Date im Service: $date")
        system.clearErrors()
        // Date is not accepted otherwise. Solution: http://stackoverflow.com/questions/14847441/grails-date-is-being-accepted-as-string Strange....
        system.setIsActive(false)
        system.retirementDate = date
        return (system.save(failOnError: true))
    }
}

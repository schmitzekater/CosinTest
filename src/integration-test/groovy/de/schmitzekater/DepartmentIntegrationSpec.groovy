package de.schmitzekater


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class DepartmentIntegrationSpec extends Specification {

    def "Set up the first Department"(){
        given: "One supervisor and his department"
        def supervisor = new Person(firstName: 'Super', lastName: 'Visor', email: 'super@visor.de').save(failOnError: true)
        def analytik = new Department(departmentName: "Analytik", supervisor: supervisor)
        when: "THe Department is saved"
        analytik.save(failOnError: true)
        then: "The Department is in the database"
        analytik.hasErrors() == false
        Department.get(analytik.id).departmentName == analytik.departmentName
    }

    def "Create a department without supervisor"(){
        given: "A new department"
        def klinik = new Department(departmentName: 'Klinik')
        when: "The department is saved"
        klinik.save(failOnError: true)
        then: "The Department was saved"
        klinik.hasErrors() == false
        Department.get(klinik.id).departmentName == klinik.departmentName
    }
    def setup() {
    }

    def cleanup() {
    }

}

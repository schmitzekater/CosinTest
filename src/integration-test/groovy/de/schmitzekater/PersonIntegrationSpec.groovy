package de.schmitzekater


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class PersonIntegrationSpec extends Specification {

   def "A simple Person created"(){
       given: "A valid Person is created"
       def meieranna = new Person(firstName: "Anna", lastName: "Meier", email: "annameier@web.de", user: null)

       when: "Anna is saved"

       meieranna.validate()
       meieranna.save(failOnError: true)
       then: "The Person is inside the database"
      // Person.findByFirstName("Anna")!=null
       Person.get(meieranna.id).firstName == meieranna.firstName

   }
}

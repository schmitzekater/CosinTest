package de.schmitzekater

import grails.test.mixin.Mock
import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
@Mock(Module)
class QualificationIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Add a qualification to a module and retreive it correctly"(){
        given: "An existing module"
        def module = new Module(moduleName: 'Agilent AG1289', moduleSerial: 'J17334AC', moduleModel: 'HPLC-Pump', moduleFirmware: 'A65.6')
        module.save(failOnError:true)

        when: "A new Qualification is added to the module"
        def qual = new Qualification(qualificationType: 'Qualification', qualificationDate: new Date(2014, 12, 5), comment: 'Test-Qualification')
        qual.save(failOnError: true)
        module.addToQualifications(qual)

        then: "The Qualification is saved and can be retrieved from the module"
        assert Qualification.count == 1
        def testModule = Module.findById('1')
        assert testModule.qualifications.count == 1
        def testQual =  testModule.qualifications.getAt(1)
        assert testQual.module.moduleName == 'Agilent AG1289'
        assert testQual.module.getDisplayString() == 'Agilent AG1289 (J17334AC)'
        assert testQual.qualificationType == 'Qualification'
        assert testQual.qualificationDate.format('dd-MMM-yyyy') == "05-Dec-2014"
        assert testQual.getDisplayString() == "20141204: Qualification Agilent AG1289 (J17334AC)"

    }
}

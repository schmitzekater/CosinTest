package de.schmitzekater

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Module)
@Mock([Qualification, Module, QualificationType])
class ModuleSpec extends Specification {

    void "Add a qualification to a module and retreive it correctly"() {
        given: "An existing module"
        def module = new Module(moduleName: 'Agilent AG1289', moduleSerial: 'J17334AC', moduleModel: 'HPLC-Pump', moduleFirmware: 'A65.6')
        module.save(failOnError: true)

        when: "A new Calibration is added to the module"
        def qual = new Qualification(qualificationType: new QualificationType(type: 'Calibration').save(), qualificationDate: new Date(114, 10, 5), comment: 'Test-Qualification') // Year = 1900 +year, Month: 0= January, 10=November
        qual.save(failOnError: true)
        module.addToQualifications(qual)

        then: "The Qualification is saved and can be retrieved from the module"
        Qualification.count == 1
        def testModule = Module.findById('1')
        testModule.qualifications.size() == 1
        def testQual = testModule.qualifications.getAt(0)
        testQual.qualificationObject instanceof Module
        testQual.qualificationObject.getDisplayString() == 'Agilent AG1289 (J17334AC)'
        testQual.qualificationType == QualificationType.findByType('Calibration')
        def testDate = testQual.qualificationDate
        testDate.format('dd-MMM-yyyy') == "05-Nov-2014"
        testQual.getDisplayString() == "05-Nov-2014: Calibration Agilent AG1289 (J17334AC)"
        testQual.comment == "Test-Qualification"
    }

}
package de.schmitzekater

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugins.rendering.image.GifRenderingService
import grails.plugins.rendering.image.JpegRenderingService
import grails.plugins.rendering.image.PngRenderingService
import grails.plugins.rendering.pdf.PdfRenderingService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(UserController)
@Mock([User, Person, PersonService, SpringSecurityService, PngRenderingService, JpegRenderingService, GifRenderingService, PdfRenderingService])  // No Idea, why these are needed! There is no dependency, howver, test crashes if they are not present. Investigate, if time!
class UserControllerSpec extends Specification {

    @Unroll
    def "Registration Command object for #userId validate correctly "() {
        given: "A mocked URC"
        def urc = mockCommandObject(UserRegistrationCommand)

        and: "a set of intial values from the spock test"
        urc.username = userId
        urc.password = password
        urc.passwordRepeat = passwordRepeat
        urc.signature = signature
        urc.signatureRepeat = signatureRepeat
        urc.firstName = "Hans"
        urc.lastName = "Albers"
        urc.email = "hans@albers.de"


        when: "The validator is invoked"
        def isValidRegistration = urc.validate()

        then: "The appropriate fields are flagged as errors"
        isValidRegistration == anticipatedValid
        urc.errors.getFieldError(fieldInError)?.code == errorCode

        where:
        userId   | password   | passwordRepeat | signature | signatureRepeat | anticipatedValid | fieldInError      | errorCode
        "hansal" | "Password1" | "falsch"       | "Hanssig" | "Hanssig"       | false            | "passwordRepeat"  | "user.rejectPassword.noMatch"
        "hansal" | "Password1" | "Password1"     | "Hanssig" | "passtnicht"    | false            | "signatureRepeat" | "user.rejectSignature.noMatch"
        "hans"   | "Password1" | "Password1"     | "Hanssig" | "Hanssig"       | false            | "username"          | "size.toosmall"
        "hansal" | "Password1" | "Password1"     | "Hanssig" | "Hanssig"       | true             | null              | null
    }
}

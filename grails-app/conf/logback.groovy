import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.*
import ch.qos.logback.core.status.OnConsoleStatusListener
import grails.util.BuildSettings
import grails.util.Environment
import org.springframework.boot.ApplicationPid

import java.nio.charset.Charset

def byDay = timestamp("yyyymmdd")
def HOSTNAME = hostname
statusListener(OnConsoleStatusListener)

/**
 * Nicer output for loggers from http://mrhaki.blogspot.de/2015/09/grails-goodness-use-different-logging.html
 */
// Get PID for Grails application.
// We use it in the logging output.
if (!System.getProperty("PID")) {
    System.setProperty("PID", (new ApplicationPid()).toString())
}

conversionRule 'clr', org.springframework.boot.logging.logback.ColorConverter
conversionRule 'wex', org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter
// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName('UTF-8')
        pattern =
                '%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} ' + // Date
                        '%clr(%5p) ' + // Log level
                        '%clr(%property{PID}){magenta} ' + // PID
                        '%clr(---){faint} %clr([%15.15t]){faint} ' + // Thread
                        '%clr(%-40.40logger{39}){cyan} %clr(:){faint} ' + // Logger
                        '%m%n%wex' // Message
    }
}
root(WARN, ['STDOUT'])

appender('FILE_ERROR', FileAppender) {
    file = "logs/${byDay}_${HOSTNAME}_errorFile.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

root(ERROR, ['STDOUT', 'FILE_ERROR'])




if (Environment.current == Environment.DEVELOPMENT) {
    root(INFO, ['STDOUT'])
    def targetDir = BuildSettings.TARGET_DIR
    if (targetDir) {
        appender("FULL_STACKTRACE", FileAppender) {
            file = "${targetDir}/stacktrace.log"
            append = true
            encoder(PatternLayoutEncoder) {
                pattern = "%level %logger - %msg%n"
            }
        }
        logger "StackTrace", ERROR, ['FULL_STACKTRACE'], false
        //see http://logback.qos.ch/manual/groovy.html for more info
        logger 'org.springframework.boot.autoconfigure.security', INFO
        logger 'grails.app.controllers', INFO, ['STDOUT']
        logger 'grails.app.services', INFO, ['STDOUT']
        logger 'grails.app.services.grails.plugin.formfields.FormFieldsTemplateService', WARN, ['STDOUT']
        logger 'grails.plugins.orm.auditable.AuditLogListener', WARN, ['STDOUT']
    }
}

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.*
import ch.qos.logback.core.status.OnConsoleStatusListener
import grails.util.BuildSettings
import grails.util.Environment

def byDay = timestamp("yyyymmdd")
def HOSTNAME = hostname
statusListener(OnConsoleStatusListener)

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}
appender('FILE_DEBUG', FileAppender) {
    file = "logs/${byDay}_${HOSTNAME}_debugFile.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

appender('FILE_ERROR', FileAppender) {
    file = "logs/${byDay}_${HOSTNAME}_errorFile.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

root(ERROR, ['STDOUT', 'FILE_ERROR'])



def targetDir = BuildSettings.TARGET_DIR
if (Environment.isDevelopmentMode() && targetDir) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%level %logger - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
    //see http://logback.qos.ch/manual/groovy.html for more info
    logger('org.springframework.boot.autoconfigure.security', INFO)
}

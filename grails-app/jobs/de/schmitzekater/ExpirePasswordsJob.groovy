package de.schmitzekater

import grails.transaction.Transactional

/*
    From http://grails-plugins.github.io/grails-spring-security-core/v3/index.html#locking
 */

class ExpirePasswordsJob {
    def sessionRequired = true
    static triggers = {
      //simple name: 'Password Expire Trigger', repeatInterval: 3000l, startDelay: 60000 , repeatCount: -1// execute job once in 5 Minutes TESTING
        cron name: 'Daily Trigger', cronExpression: '0 5 0 * * ?'  // Daily at 0:05
    }

    @Transactional
    void execute() {
        def date = new Date()
        println "${date}: Running Job Expire Passwords."


        def users = User.executeQuery(
                'from User u where u.passwordChangeDate <= :cutoffDate',
                [cutoffDate: new Date() - 2]) // TODO: Set real value!!

        for (user in users) {
            // flush each separately so one failure doesn't rollback all of the others
            try {
                user.passwordExpired = true
                user.save(flush: true)
            }
            catch (e) {
                log.error "problem expiring password for user $user.username : $e.message", e
            }
        }
    }
}

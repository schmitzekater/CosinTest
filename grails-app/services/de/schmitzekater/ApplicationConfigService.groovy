package de.schmitzekater

import org.springframework.beans.factory.annotation.Value

/**
 * This service will provide values from the Application.yml file
 * Those values can be defined per environment.
 */

class ApplicationConfigService {

    static transactional = false

    // Base Dir for all Uploads
    @Value('${config.uploadDirectory}')
    final String uploadDir

    // Dir for all qualification files
    @Value('${config.qualificationDirectory}')
    final String qualificationDir

    // Dir for all dataflow files
    @Value('${config.dataflowDirectory}')
    final String dataflowDir

    // Test for minsize of usernames
    @Value('${config.usernameMinSize}')
    final int usernameMinSize

    // Time for expiration of passwords
    @Value('${config.passwordExpirationDays}')
    final int passwordExpirationDays


}

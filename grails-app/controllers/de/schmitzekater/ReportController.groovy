package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * This controller takes the actions for creating Reports
 * Reports are generated via @ReportService
 */
class ReportController {

    def reportService                               /** DependencyInjection for the ReportService */
    def index() {}

    def createSystemReport(System system) {
        reportService.createSystemOverview(system)
    }
}

package de.schmitzekater

/**
 * @autor Alexander Schmitz
 *
 * Controller to handle the Domain class Computer.
 */

class ComputerController {
    static scaffold = Computer

    def index() {
        redirect action: 'list', params: params
    }

    /*
    Tabular View of all Computer
     */
    def list() {
        if(!params.max) params.max = 10
        def computer = Computer.list(params)
        render view:"/layouts/list", model: [model:computer, count: Computer.count]
    }

    /*
    Detailed view of a single Computer
     */
    def detail(Computer computer){
        render view: "/layouts/detail", model:  [computer: computer]
    }
    def show(Computer computer){
        render view: "/layouts/detail", model:  [computer: computer]
    }

    /*
    View to edit one Computer
     */
    def edit(Computer computer) {
        respond computer
    }

    /*
    Method to add an existing Software to a Computer
     */
    def addSoftware(Computer computer) {
        def software = Software.get(params.software)
        computer.addToInstalledSoftware(software)
        flash.message = "Added $software.softwareName to Computer $computer.computerName"
        log.info(flash.message)
        redirect action: 'detail', id: computer.id
    }

    /*
    Method to remove an installed software from a Computer
     */
    def removeSoftware(Computer computer) {
        def software = Software.get(params.software)
        computer.removeFromInstalledSoftware(software)
        flash.message = "Removed $software.softwareName from Computer $computer.computerName"
        log.info(flash.message)
        redirect action: 'detail', id: computer.id
    }

    /*
    View to add a Software to a Computer
     */
    def addSoftwareToComputer(Computer computer) {
        model: [computer: computer]
    }

}

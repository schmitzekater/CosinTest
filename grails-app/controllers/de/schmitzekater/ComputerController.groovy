package de.schmitzekater

class ComputerController {
    static scaffold = Computer

    def index() {
        redirect action: 'list', params: params
    }
    def list() {
        if(!params.max) params.max = 10
        def computer = Computer.list(params)
        render view:"/layouts/list", model: [model:computer, count: Computer.count]
    }
    def detail(Computer computer){
        render view: "/layouts/detail", model:  [computer: computer]
    }
    def show(Computer computer){
        render view: "/layouts/detail", model:  [computer: computer]
    }
    def edit(Computer computer) {
        respond computer
    }

    def addSoftware(Computer computer) {
        def software = Software.get(params.software)
        computer.addToInstalledSoftware(software)
        flash.message = "Added $software.softwareName to Computer $computer.computerName"
        log.info(flash.message)
        redirect action: 'detail', id: computer.id
    }

    def removeSoftware(Computer computer) {
        def software = Software.get(params.software)
        computer.removeFromInstalledSoftware(software)
        flash.message = "Removed $software.softwareName from Computer $computer.computerName"
        log.info(flash.message)
        redirect action: 'detail', id: computer.id
    }

    def addSoftwareToComputer(Computer computer) {
        model: [computer: computer]
    }

}

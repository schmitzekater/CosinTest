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
    def detail(){
        render view: "/layouts/detail", model:  [computer: Computer.findById(params.id)]
    }
    def show(){
        render view: "/layouts/detail", model:  [computer: Computer.findById(params.id)]
    }

    def addSoftware() {
        def software = Software.get(params.software)
        def computer = Computer.get(params.id)
        computer.addToInstalledSoftware(software)
        flash.message = "Added $software.softwareName to Computer $computer.computerName"
        log.info(flash.message)
        redirect action: 'detail', id: computer.id
    }

    def removeSoftware() {
        def software = Software.get(params.software)
        def computer = Computer.get(params.id)
        computer.removeFromInstalledSoftware(software)
        flash.message = "Removed $software.softwareName from Computer $computer.computerName"
        log.info(flash.message)
        redirect action: 'detail', id: computer.id
    }

    def addSoftwareToComputer() {
        render view: "/layouts/addSoftwareToComputer", params: params
    }

}

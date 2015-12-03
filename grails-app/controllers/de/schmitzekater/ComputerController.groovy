package de.schmitzekater

class ComputerController {
    static scaffold = Computer

    def index() {
        list()
    }
    def list() {
        def computer = Computer.getAll()
        render view:"/layouts/list", model: [model:computer, count: Computer.count]
    }
}

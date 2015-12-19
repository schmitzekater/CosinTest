package de.schmitzekater

class ComputerController {
    static scaffold = Computer

    def index() {
        def computer = Computer.getAll()
        render view:"/layouts/list", model: [model:computer, count: Computer.count]
    }
    def list() {
        def computer = Computer.getAll()
        render view:"/layouts/list", model: [model:computer, count: Computer.count]
    }
    def detail(){
        render view: "/layouts/detail", model:  [computer: Computer.findById(params.id)]
    }
    def show(){
        render view: "/layouts/detail", model:  [computer: Computer.findById(params.id)]
    }
}

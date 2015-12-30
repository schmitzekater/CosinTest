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
}

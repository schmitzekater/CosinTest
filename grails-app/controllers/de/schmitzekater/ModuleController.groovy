package de.schmitzekater

class ModuleController {
    static scaffold = Module
    static defaultAction = "list"

    def index() {}

    def list() {
        def modules = Module.getAll()
        render view:"/layouts/list", model: [model: modules, count: Module.count]
    }
}

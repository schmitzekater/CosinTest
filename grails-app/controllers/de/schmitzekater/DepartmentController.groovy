package de.schmitzekater

class DepartmentController {
    static scaffold = Department
    def index() {
        redirect action: 'list', params: params
    }
    def list(){
        if (!params.max) params.max = 10
        def departments = Department.list(params)
        render view:"/layouts/list", model: [model: departments, count: Department.count]
    }
}

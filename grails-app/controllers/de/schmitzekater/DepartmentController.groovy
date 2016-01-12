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

    def createDepartment(){
        def department = new Department(params)
        if(department.validate()){
            department.save(failOnError: true)
            flash.message = message(code: 'default.created.message', args: ['Department', department.departmentName])
            redirect(action: 'list')
        }
    }

    def show(){
        redirect action: 'detail', params: params
    }

    def detail(){
        def department = Department.findById(params.id)
        render view: "/layouts/detail", model: [department: department]
    }

    def edit() {
        def department = Department.findById(params.id)
        // Get the List of persons that are not supervisors
        List<Person> supervisors = Person.getAvailableSupervisors()
        //add the current supervisor if present
        if (department.supervisor != null) {
            supervisors.add(department.supervisor)
        }
        render view: "edit", model: [department: department, availableSupervisors: supervisors]
    }

    def create() {
        List<Person> supervisors = Person.getAvailableSupervisors()
        render view: "create", model: [department: new Department(), availableSupervisors: supervisors]
    }
}

package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Controller to handle Department views and methods.
 */
class DepartmentController {
    static scaffold = Department
    def index() {
        redirect action: 'list', params: params
    }
    /*
    Tabular view of all Departments
     */
    def list(){
        if (!params.max) params.max = 10
        def departments = Department.list(params)
        render view:"/layouts/list", model: [model: departments, count: Department.count]
    }

    /*
    Method to save a new Department.
    TODO: Refactor method into Service.
     */
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

    /*
    Detailed view of a single Department.
     */
    def detail(){
        def department = Department.findById(params.id)
        render view: "/layouts/detail", model: [department: department]
    }

    /*
    View to edit a Department
     */
    def edit() {
        def department = Department.findById(params.id)
        // Get the List of persons that are not supervisors
        List<Person> supervisors = Person.getAvailableSupervisors()
        if (department.supervisor != null) {
            // Adds the current supervisor to the list of available supervisors.
            supervisors.add(department.supervisor)
        }
        render view: "edit", model: [department: department, availableSupervisors: supervisors]
    }

    /*
    View to create a new Department
     */
    def create() {
        List<Person> supervisors = Person.getAvailableSupervisors()     // Fetches only that Persons, that are not already "supervisors"
        render view: "create", model: [department: new Department(), availableSupervisors: supervisors]
    }
}

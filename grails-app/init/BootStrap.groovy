import de.schmitzekater.*

class BootStrap {

    def init = { servletContext ->
        environments{
            development {
//                if(!Person.count()) createPersons()
                //if(!User.count()) createUsers()
                //if(!Department.count()) createDepartments()
            }
        }
    }

    def createPersons(){
        print "Creating Persons"
//        def anna =
//        anna.save()
//        def lisa = new Person(firstname: 'Lisa', lastName: 'Mueller', email: 'lisa@mueller.de', user: null)
//        lisa.save()
//        def bernd = new Person(firstName: 'Bernd', lastName: 'Waldorf', email: 'bernd@iamtheking.de', user: null)
//        bernd.save()
//
//        def now = new Date()
//
        def annaUser = new User(userId: 'anname', password:'geheim', signature:'signature')
        annaUser.person = new Person(firstname: 'Anna', lastName: 'Meier', email: 'anna@meier.de')
        annaUser.save(failOnError: true)




//        def analytik = new Department(departmentName: 'Analytik', supervisor: anna)
//        analytik.save(failOnError: true)
        flush()
    }
    def destroy = {
    }
}

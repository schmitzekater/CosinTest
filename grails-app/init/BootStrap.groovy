import de.schmitzekater.*

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                if (!Person.count()) createPersons()
                //if(!User.count()) createUsers()
                if (!Department.count()) createDepartments()
                if (!ComputerRole.count()) createComputerRoles()
                if (!System.count()) createSystems()
                if (!Vendor.count()) createVendors()
                if (!Computer.count()) createComputers()
                if (!Software.count()) createSoftware()
                if (!Qualification.count()) createQualifications()
                createBindings()
            }
        }
    }

    def createBindings() {
        System analyst = System.findBySystemName('Analyst')
        Software analystSW = Software.findBySoftwareName('Analyst')
        def serverOne = Computer.findByComputerName("NUCRODATA")
        def clientOne = Computer.findByComputerName("PC1234")
        analyst.addToServers(serverOne)
        analyst.addToClients(clientOne)
        serverOne.addToInstalledSoftware(analystSW)
        clientOne.addToInstalledSoftware(analystSW)
        analystSW.addToQualifications(Qualification.findById(1))
        println("System " + analyst.systemName + " has " + analyst.clients.size() + " clients and " + analyst.servers.size() + " servers")
    }

    def createQualifications() {
        println("Creating Qualifications")
        def qualOne = new Qualification(qualificationDate: new Date(), qualificationType: "Validation", comment: "Erste Validierung von Analyst.")
        qualOne.save(failOnError: true)
        println("Created " + Qualification.count() + " Qualifications")
    }

    def createSoftware() {
        println("Creating Software")
        def analystSW = new Software(softwareName: 'Analyst', softwareVersion: '1.6.2', softwareVendor: Vendor.findByName('AB Sciex'), softwareIqOq: "projekte\\sowas\\da")
        def empowerSW = new Software(softwareName: 'Empower', softwareVersion: '3', softwareVendor: Vendor.findByName('Waters'), softwareIqOq: "projekte\\sowas\\da")
        analystSW.save(failOnError: true)
        empowerSW.save()
        println("Created " + Software.count() + " software.")
    }


    def createComputers() {
        println("Creating Computers")
        def serverOne = new Computer(computerName: 'NUCRODATA', computerVendor: Vendor.findByName('AB Sciex'), computerRole: ComputerRole.findByRole("Fileserver"))
        def clientOne = new Computer(computerName: 'PC1234', computerVendor: Vendor.findByName('Waters'), computerRole: ComputerRole.findByRole("Client"))
        serverOne.save()
        clientOne.save()
        println("Created " + Computer.count() + " computers.")
    }

    def createVendors() {
        println("Creating Vendors")
        def sciex = new Vendor(name: 'AB Sciex')
        def waters = new Vendor(name: 'Waters')
        sciex.save()
        waters.save()
        println("Created " + Vendor.count() + " vendors.")
    }

    def createSystems() {
        println("Creating Systems")
        def analyst = new System(systemName: 'Analyst', area: 'GLP')
        def empower = new System(systemName: 'Empower', area: 'GMP')
        analyst.save()
        empower.save()
        println("Created " + System.count() + " systems.")
    }

    def createComputerRoles() {
        println("Creating Computer Roles")
        def dbServer = new ComputerRole("Database Server")
        def fileServer = new ComputerRole("Fileserver")
        def client = new ComputerRole("Client")
        dbServer.save()
        fileServer.save()
        client.save()
    }

    def createDepartments() {
        println("Creating Departments")
        def analytik = new Department(departmentName: 'Analytik', supervisor: Person.findById(2))
        analytik.save()
        def pas = new Department(departmentName: 'PAS', supervisor: Person.findByLastName('Mueller'))
        pas.save()
    }

    def createPersons() {
        println("Creating Persons")
        def lisa = new Person(firstName: 'Lisa', lastName: 'Mueller', email: 'lisa@mueller.de')
        lisa.save()
        def bernd = new Person(firstName: 'Bernd', lastName: 'Waldorf', email: 'bernd@iamtheking.de')
        bernd.save()
        def hans = new Person(email: 'hans@automat.de', firstName: 'Hans', lastName: 'Zimmer')
        hans.save()
    }

    def destroy = {
    }

}
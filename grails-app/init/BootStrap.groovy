import de.schmitzekater.*

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                if (!Person.count()) createPersons()
                if (!User.count()) createUsers()
                if (!Department.count()) createDepartments()
                if (!ComputerRole.count()) createComputerRoles()
                if (!System.count()) createSystems()
                if (!Vendor.count()) createVendors()
                if (!Computer.count()) createComputers()
                if (!Software.count()) createSoftware()
                if (!QualificationType.count()) createQualificationTypes()
                if (!Qualification.count()) createQualifications()
                if (!ModuleType.count()) createModuleTypes()
                if (!Module.count()) createModules()
                if (!DataCategory.count()) createDataCategories()
                if (!ConnectionType.count()) createConnectionTypes()
                createBindings()
            }
        }
    }

    def createBindings() {
        System analyst = System.findBySystemName('Analyst')
        Software analystSW = Software.findBySoftwareName('Analyst')
        println "Found Analyst: "+analystSW.getDisplayString()
        Software empower = Software.findBySoftwareName('Empower')
        println "Found Empower: "+empower.getDisplayString()
        def serverOne = Computer.findByComputerName("NUCRODATA")
        def clientOne = Computer.findByComputerName("PC1234")
        analyst.addToServers(serverOne)
        analyst.addToClients(clientOne)
        serverOne.addToInstalledSoftware(analystSW)
        clientOne.addToInstalledSoftware(analystSW)
        analystSW.addToQualifications(Qualification.findById(1))
        println "System $analyst.systemName has ${analyst.clients.size()} clients and ${analyst.servers.size()} servers"
    }

    def createModules(){
        println "Creating Modules"
        def sampler = new Module(moduleSerial: 'AS0815', moduleName: 'AS-12', moduleModel: 'CTC PAL xT', moduleType: ModuleType.findByModuleType('Autosampler'), moduleConnection: ConnectionType.findByConnection('Serial'), moduleFirmware: '4.0.2', needsCalibration: true, calibInterval: 2, calibPeriod: 'W')
        def pump = new Module(moduleSerial: 'G13289', moduleName: 'Pump-26', moduleModel: 'G1260', moduleType: ModuleType.findByModuleType('Unary LC Pump'), moduleConnection: ConnectionType.findByConnection('Ethernet'), moduleFirmware: 'A55.1', needsCalibration: false)
        pump.save(failOnError: true)
        sampler.save(failOnError: true)
        println "Created "+Module.count()+" Modules"
    }

    def createConnectionTypes() {
        println "Creating Connection Types"
        String[] connections = ["Serial", "Ethernet", "Parallel", "IEEE", "USB"]
        ConnectionType[] ct = new ConnectionType[connections.length]
        for (int i = 0; i < connections.length; i++) {
            ct[i] = new ConnectionType(connection: connections[i])
            ct[i].save(failOnError: true)
        }
        println "Created " + ConnectionType.count() + " ConnectionTypes"
    }

    def createDataCategories() {
        println "Creating Data Categories"
        String[] categories = ["A - Paper", "B - Hybrid", "C - Partly Compliant", "D - Full Compliant"]
        DataCategory[] dc = new DataCategory[categories.length]
        for (int i = 0; i < categories.length; i++) {
            dc[i] = new DataCategory(category: categories[i])
            dc[i].save(failOnError: true)
        }
        println "Created " + DataCategory.count() + " DataCategories"
    }

    def createModuleTypes(){
        println "Creating Module Types"
        String[] types = ["Column Oven", "Autosampler",  "Mass Spectrometer", "Unary LC Pump", "Binary LC Pump", "Quarternary LC Pump", "Degasser", "Detector"]
        ModuleType[] mt = new ModuleType[types.length]
        for (int i = 0; i < types.length; i++) {
            mt[i]=new ModuleType(moduleType: types[i])
            mt[i].save(failOnError: true)
        }
        println "Created "+ModuleType.count()+" ModuleTypes"
    }

    def createQualifications() {
        println "Creating Qualifications"
        def qualOne = new Qualification(qualificationDate: new Date(), qualificationType: QualificationType.findByType('Validation'), comment: "Erste Validierung von Analyst.")
        qualOne.save(failOnError: true)
        println "Created " + Qualification.count() + " Qualifications"
    }

    def createQualificationTypes() {
        println "Creating Qualification Types"
        String[] types = ["Qualification", "Validation", "Calibration", "Periodic Review"]
        QualificationType[] qt = new QualificationType[types.length]
        for (int i = 0; i < types.length; i++) {
            qt[i] = new QualificationType(type: types[i])
            qt[i].save(failOnError: true)
        }
        println "Created " + QualificationType.count() + " QualificationTypes"
    }

    def createSoftware() {
        println "Creating Software"
        def analystSW = new Software(softwareName: 'Analyst', softwareVersion: '1.6.2', softwareVendor: Vendor.findByName('AB Sciex'), softwareIqOq: "projekte\\sowas\\da")
        def empowerSW = new Software(softwareName: 'Empower', softwareVersion: '3', softwareVendor: Vendor.findByName('Waters'), softwareIqOq: "projekte\\sowas\\da")
        analystSW.save(failOnError: true)
        empowerSW.save(failOnError: true)

        println "Created " + Software.count() + " software."
        println "Created: "+analystSW.getDisplayString()
        println "Created: "+empowerSW.getDisplayString()
    }


    def createComputers() {
        println("Creating Computers")
        def serverOne = new Computer(computerName: 'NUCRODATA', computerVendor: Vendor.findByName('AB Sciex'), computerRole: ComputerRole.findByRole("Fileserver"))
        def clientOne = new Computer(computerName: 'PC1234', computerVendor: Vendor.findByName('Waters'), computerRole: ComputerRole.findByRole("Client"))
        def clientOffice = new Computer(computerName: 'PC0888', computerVendor: Vendor.findByName('Dell'), computerRole: ComputerRole.findByRole("Client"))
        serverOne.save(failOnError: true)
        clientOne.save(failOnError: true)
        clientOffice.save(failOnError: true)
        println("Created " + Computer.count() + " computers.")
    }

    def createVendors() {
        println("Creating Vendors")
        def sciex = new Vendor(name: 'AB Sciex')
        def waters = new Vendor(name: 'Waters')
        def dell = new Vendor(name: 'Dell')
        sciex.save(failOnError: true)
        waters.save(failOnError: true)
        dell.save(failOnError: true)
        println("Created " + Vendor.count() + " vendors.")
    }

    def createSystems() {
        println("Creating Systems")
        def analyst = new System(systemName: 'Analyst', area: 'GLP')
        def empower = new System(systemName: 'Empower', area: 'GMP')
        analyst.save(failOnError: true)
        empower.save(failOnError: true)
        println("Created " + System.count() + " systems.")
    }

    def createComputerRoles() {
        println "Creating Computer Roles"
        String[] roles = ["Database Server", "Fileserver", "Unspecified Server", "Unspecified Client", "Acquisition Client", "Processing Server", "Application Server", "Communication Server", "Office Client"]
        ComputerRole[] cr = new ComputerRole[roles.length]
        for (int i = 0; i < roles.length; i++) {
            cr[i] = new ComputerRole(role: roles[i])
            cr[i].save(failOnError: true)
        }
        println('Created ' + ComputerRole.count() + ' ComputerRoles.')
    }

    def createDepartments() {
        println("Creating Departments")
        def analytik = new Department(departmentName: 'Analytik', supervisor: Person.findById(2))
        def pas = new Department(departmentName: 'PAS', supervisor: Person.findByLastName('Mueller'))
        def it = new Department(departmentName: 'ITS', supervisor: Person.findByLastName('Herrmann'))
        def cts = new Department(departmentName: 'CTS', supervisor: Person.findByLastName('Kasubke'))
        analytik.save(failOnError: true)
        pas.save(failOnError: true)
        it.save(failOnError: true)
        cts.save(failOnError: true)
        println('Created ' + Department.count() + ' departments.')
    }

    def createUsers() {
        println("Creating Users")
        def lisaU = new User(userId: 'lisamu', password: 'password', signature: 'lisassignature', person: Person.findByLastName('Mueller'), lastPasswordChange: new Date())
        def berndU = new User(userId: 'berndw', password: 'password', signature: 'berndistoll', person: Person.findByLastName('Waldorf'), lastPasswordChange: new Date())
        def hansU = new User(userId: 'hanszi', password: 'password', signature: 'Musicismylife', person: Person.findByLastName('Zimmer'), lastPasswordChange: new Date())
        def peterU = new User(userId: 'peterh', password: 'password', signature: 'HERRMANN!', person: Person.findByLastName('Herrmann'), lastPasswordChange: new Date())
        def ernaU = new User(userId: 'ernaka', password: 'password', signature: 'weissichnicht', person: Person.findByLastName('Kasubke'), lastPasswordChange: new Date())
        lisaU.save(failOnError: true)
        berndU.save(failOnError: true)
        hansU.save(failOnError: true)
        peterU.save(failOnError: true)
        ernaU.save(failOnError: true)
        println('Created ' + User.count() + ' user.')
    }

    def createPersons() {
        println("Creating Persons")
        def lisa = new Person(firstName: 'Lisa', lastName: 'Mueller', email: 'lisa@mueller.de')
        def bernd = new Person(firstName: 'Bernd', lastName: 'Waldorf', email: 'bernd@iamtheking.de')
        def hans = new Person(email: 'hans@automat.de', firstName: 'Hans', lastName: 'Zimmer')
        def peter = new Person(email: 'peter@automat.de', firstName: 'Peter', lastName: 'Herrmann')
        def erna = new Person(email: 'erna@kasupke.de', firstName: 'Erna', lastName: 'Kasubke')
        def anna = new Person(email: 'anna@kasupke.de', firstName: 'Anna', lastName: 'Kasubke')
        lisa.save(failOnError: true)
        bernd.save(failOnError: true)
        hans.save(failOnError: true)
        peter.save(failOnError: true)
        erna.save(failOnError: true)
        anna.save(failOnError: true)
        println('Created ' + Person.count() + " persons.")
    }

    def destroy = {
    }

}
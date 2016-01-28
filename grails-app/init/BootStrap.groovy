import de.schmitzekater.*

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                if (!Person.count()) createPersons()
                if (!Role.count() && !RoleGroup.count()) createUserRoles()
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
                if (!Unit.count()) createUnits()
                if (!DataCategory.count()) createDataCategories()
                if (!ConnectionType.count()) createConnectionTypes()
                createBindings()
            }
            production {
                if (!Role.count() && !RoleGroup.count()) createUserRoles()
                if (!Person.count() && !User.count()) createProductionUsers()
                else {
                    def admin = User.findByUsername('administrator')
                    if (admin) {
                        admin.accountLocked = false
                        admin.resetFalsePasswordCount()
                        admin.accountExpired = false
                        admin.setPasswordChangeDate(new Date())
                    }
                }
                if (!QualificationType.count()) createQualificationTypes()
                if (!ComputerRole.count()) createComputerRoles()
                if (!DataCategory.count()) createDataCategories()
                if (!ConnectionType.count()) createConnectionTypes()
                if (!ModuleType.count()) createModuleTypes()
            }
        }
    }

    def createProductionUsers() {
        def adminPerson = new Person(firstName: 'Administrator', lastName: 'System', email: 'support@cosin.de')
        adminPerson.save(failOnError: true)
        def adminUser = new User('administrator', 'System1', 'signature', adminPerson, null)
        adminUser.save(failOnError: true)
        assert Person.count() == 1
        assert User.count() == 1
        def adminGroup = RoleGroup.findByDisplayString('Administrator')
        UserRoleGroup.create adminUser, adminGroup, true
        assert UserRoleGroup.count() == 1
    }

    def createBindings() {
        System analyst = System.findBySystemName('Analyst')
        Software analystSW = Software.findBySoftwareName('Analyst')
        log.info "Found Analyst: " + analystSW.getDisplayString()
        Software empower = Software.findBySoftwareName('Empower')
        log.info "Found Empower: " + empower.getDisplayString()
        def serverOne = Computer.findByComputerName("NUCRODATA")
        def clientOne = Computer.findByComputerName("PC1234")
        ComputerRole server = ComputerRole.findByRole("Fileserver")
        ComputerRole dbserver = ComputerRole.findByRole("Database Server")
        ComputerRole client = ComputerRole.findByRole("Acquisition Client")
        def firstRole = SystemRole.create(serverOne, analyst, server, true)
        def secondRole = SystemRole.create(clientOne, analyst, client, true)
        def thirdRole = SystemRole.create(serverOne, analyst, dbserver, true )
        serverOne.addToInstalledSoftware(analystSW)
        clientOne.addToInstalledSoftware(analystSW)
        for (i in 1..Qualification.count()) analystSW.addToQualifications(Qualification.get(i))
        log.info "${SystemRole.count()} System Roles created."
        log.info "System $analyst.systemName has ${analyst.getComputer().size()} Computer"
    }
    def createUnits(){
        log.info "Creating Units"
        def unit = new Unit(unitName: "LCMS01", system: System.findBySystemName("Analyst"))
        unit.save(failOnError: true)
        unit.addToModules(Module.findByModuleName('AS-12'))
        log.info "Created " + Unit.count() + " Units"
    }

    def createModules(){
        log.info "Creating Modules"
        def sampler = new Module(moduleSerial: 'AS0815', moduleName: 'AS-12', moduleModel: 'CTC PAL xT', moduleType: ModuleType.findByModuleType('Autosampler'), moduleConnection: ConnectionType.findByConnection('Serial'), moduleFirmware: '4.0.2', needsCalibration: true, calibInterval: 2, calibPeriod: 'Weeks')
        def pump = new Module(moduleSerial: 'G13289', moduleName: 'Pump-26', moduleModel: 'G1260', moduleType: ModuleType.findByModuleType('Unary LC Pump'), moduleConnection: ConnectionType.findByConnection('Ethernet'), moduleFirmware: 'A55.1', needsCalibration: false)
        pump.save(failOnError: true)
        sampler.save(failOnError: true)
        log.info "Created " + Module.count() + " Modules"
    }

    def createConnectionTypes() {
        log.info "Creating Connection Types"
        String[] connections = ["Serial", "Ethernet", "Parallel", "IEEE", "USB"]
        ConnectionType[] ct = new ConnectionType[connections.length]
        for (int i = 0; i < connections.length; i++) {
            ct[i] = new ConnectionType(connection: connections[i])
            ct[i].save(failOnError: true)
        }
        log.info "Created " + ConnectionType.count() + " ConnectionTypes"
    }

    def createDataCategories() {
        log.info "Creating Data Categories"
        String[] categories = ["A - Paper", "B - Hybrid", "C - Partly Compliant", "D - Full Compliant"]
        DataCategory[] dc = new DataCategory[categories.length]
        for (int i = 0; i < categories.length; i++) {
            dc[i] = new DataCategory(category: categories[i])
            dc[i].save(failOnError: true)
        }
        log.info "Created " + DataCategory.count() + " DataCategories"
    }

    def createModuleTypes(){
        log.info "Creating Module Types"
        String[] types = ["Column Oven", "Autosampler",  "Mass Spectrometer", "Unary LC Pump", "Binary LC Pump", "Quarternary LC Pump", "Degasser", "Detector"]
        ModuleType[] mt = new ModuleType[types.length]
        for (int i = 0; i < types.length; i++) {
            mt[i]=new ModuleType(moduleType: types[i])
            mt[i].save(failOnError: true)
        }
        log.info "Created " + ModuleType.count() + " ModuleTypes"
    }

    def createQualifications() {
        log.info "Creating Qualifications"
        def type = QualificationType.findByType('Validation')
        def qual = []
        for (i in 0..30) {
            qual[i] = new Qualification(qualificationDate: new Date().minus(i), qualificationType: type, comment: "Validierung ${i + 1} von Analyst.")
            qual[i].save failOnError: true
        }
        log.info "Created " + Qualification.count() + " Qualifications"
    }

    def createQualificationTypes() {
        log.info "Creating Qualification Types"
        String[] types = ["Qualification", "Validation", "Calibration", "Periodic Review"]
        QualificationType[] qt = new QualificationType[types.length]
        for (int i = 0; i < types.length; i++) {
            qt[i] = new QualificationType(type: types[i])
            qt[i].save(failOnError: true)
        }
        log.info "Created " + QualificationType.count() + " QualificationTypes"
    }

    def createSoftware() {
        log.info "Creating Software"
        def analystSW = new Software(softwareName: 'Analyst', softwareVersion: '1.6.2', softwareVendor: Vendor.findByName('AB Sciex'), softwareIqOq: "projekte\\sowas\\da")
        def empowerSW = new Software(softwareName: 'Empower', softwareVersion: '3', softwareVendor: Vendor.findByName('Waters'), softwareIqOq: "projekte\\sowas\\da")
        analystSW.save(failOnError: true)
        empowerSW.save(failOnError: true)

        log.info "Created " + Software.count() + " software."
        log.info "Created: " + analystSW.getDisplayString()
        log.info "Created: " + empowerSW.getDisplayString()
    }


    def createComputers() {
        log.info("Creating Computers")
        def serverOne = new Computer(computerName: 'NUCRODATA', computerVendor: Vendor.findByName('AB Sciex'))//, computerRole: ComputerRole.findByRole("Fileserver"))
        def clientOne = new Computer(computerName: 'PC1234', computerVendor: Vendor.findByName('Waters'))//, computerRole: ComputerRole.findByRole("Client"))
        def clientOffice = new Computer(computerName: 'PC0888', computerVendor: Vendor.findByName('Dell'))//, computerRole: ComputerRole.findByRole("Client"))
        serverOne.save(failOnError: true)
        clientOne.save(failOnError: true)
        clientOffice.save(failOnError: true)
        log.info("Created " + Computer.count() + " computers.")
    }

    def createVendors() {
        log.info("Creating Vendors")
        def addressOne = new Address(streetOne: "Street", zip: '88888', country: 'deu', county: 'BW')
        def addressTwo = new Address(streetOne: "Street", zip: '9999', country: 'deu', county: 'BY')
        def addressThree = new Address(streetOne: "Street", zip: '11111', country: 'deu', county: 'RP')
        addressOne.save()
        addressTwo.save()
        addressThree.save()
        log.info "Create ${Address.count()} Addresses"
        def sciex = new Vendor(name: 'AB Sciex', address: addressOne)
        def waters = new Vendor(name: 'Waters', address: addressTwo)
        def dell = new Vendor(name: 'Dell', address: addressThree)
        sciex.save(failOnError: true)
        waters.save(failOnError: true)
        dell.save(failOnError: true)
        log.info("Created " + Vendor.count() + " vendors.")
    }

    def createSystems() {
        log.info("Creating Systems")
        def analyst = new System(systemName: 'Analyst', area: 'GLP')
        def empower = new System(systemName: 'Empower', area: 'GMP')
        analyst.save(failOnError: true)
        empower.save(failOnError: true)
        log.info("Created " + System.count() + " systems.")
    }

    def createComputerRoles() {
        log.info "Creating Computer Roles"
        String[] roles = ["Database Server", "Fileserver", "Unspecified Server", "Unspecified Client", "Acquisition Client", "Processing Server", "Application Server", "Communication Server", "Office Client"]
        ComputerRole[] cr = new ComputerRole[roles.length]
        for (int i = 0; i < roles.length; i++) {
            cr[i] = new ComputerRole(role: roles[i])
            cr[i].save(failOnError: true)
        }
        log.info('Created ' + ComputerRole.count() + ' ComputerRoles.')
    }

    def createDepartments() {
        log.info("Creating Departments")
        def analytik = new Department(departmentName: 'Analytik', supervisor: Person.findById(2))
        def pas = new Department(departmentName: 'PAS', supervisor: Person.findByLastName('Mueller'))
        def it = new Department(departmentName: 'ITS', supervisor: Person.findByLastName('Herrmann'))
        def cts = new Department(departmentName: 'CTS', supervisor: Person.findByLastName('Kasubke'))
        analytik.save(failOnError: true)
        pas.save(failOnError: true)
        it.save(failOnError: true)
        cts.save(failOnError: true)
        log.info('Created ' + Department.count() + ' departments.')
    }

    def createUsers() {
        log.info "Creating Users"
        def lisaU = new User('lisamu', 'Password1', 'lisassignature', Person.findByLastName('Mueller'), null)
        def berndU = new User('berndw', 'Password1', 'berndistoll', Person.findByLastName('Waldorf'), new Date() - 1)
        def hansU = new User('hanszi', 'Password1', 'Musicismylife', Person.findByLastName('Zimmer'), new Date() - 2)
        def peterU = new User('peterh', 'Password1', 'HERRMANN!', Person.findByLastName('Herrmann'), new Date() - 3)
        def ernaU = new User('ernaka', 'Password1', 'weissichnicht', Person.findByLastName('Kasubke'), new Date() - 4)

        lisaU.save(failOnError: true)
        berndU.save(failOnError: true)
        berndU.passwordExpired = true
        hansU.save(failOnError: true)
        peterU.save(failOnError: true)
        ernaU.save(failOnError: true)

        def adminGroup = RoleGroup.findByDisplayString('Administrator')
        def superGroup = RoleGroup.findByDisplayString('Superuser')
        def normGroup = RoleGroup.findByDisplayString('User')
        def readGroup = RoleGroup.findByDisplayString('Read-Only')

        UserRoleGroup.create lisaU, adminGroup, true
        UserRoleGroup.create berndU, superGroup, true
        UserRoleGroup.create hansU, normGroup, true
        UserRoleGroup.create peterU, readGroup, true


        log.info('Created ' + User.count() + ' user.')
    }

    def createUserRoles() {
        log.info "Creating Roles."
        def deleteRole = new Role('ROLE_DELETE').save()
        def editRole = new Role('ROLE_EDIT').save()
        def createRole = new Role('ROLE_CREATE').save()
        def readRole = new Role('ROLE_READ').save()

        def adminGroup = new RoleGroup('ROLE_ADMIN', 'Administrator').save()
        def superGroup = new RoleGroup('ROLE_SUPER', 'Superuser').save()
        def normGroup = new RoleGroup('ROLE_NORMAL', 'User').save()
        def readGroup = new RoleGroup('ROLE_RO', 'Read-Only').save()
        RoleGroupRole.create adminGroup, deleteRole, true
        RoleGroupRole.create adminGroup, editRole, true
        RoleGroupRole.create adminGroup, createRole, true
        RoleGroupRole.create adminGroup, readRole, true

        RoleGroupRole.create superGroup, editRole, true
        RoleGroupRole.create superGroup, createRole, true
        RoleGroupRole.create superGroup, readRole, true

        RoleGroupRole.create normGroup, createRole, true
        RoleGroupRole.create normGroup, readRole, true

        RoleGroupRole.create readGroup, readRole, true
        log.info "Created ${Role.count()} Roles and ${RoleGroup.count()} Groups."
    }

    def createPersons() {
        log.info("Creating Persons")
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
        log.info('Created ' + Person.count() + " persons.")
    }

    def destroy = {
    }

}
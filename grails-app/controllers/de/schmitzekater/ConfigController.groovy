package de.schmitzekater

class ConfigController {
    def qualificationTypeService
    def moduleTypeService
    def dataCategoryService
    def connectionTypeService
    def computerRoleService

    def index(){

    }

    def config() {
        def qt = QualificationType.list()
        def cr = ComputerRole.list()
        def dc = DataCategory.list()
        def mt = ModuleType.list()
        def ct = ConnectionType.list()
        [qualificationTypes: qt, computerRoles: cr, dataCategories: dc, moduleTypes: mt, connectionTypes: ct]
    }
    /**
     * Die folgenden Methoden ergänzen die statischen Strings zu
     * DataCategory
     * QualificationType
     * ModuleType
     * ConnectionType
     * ComputerRole
     * Die Seite wird per AJAX in Teilen neu geladen, nachdem ein Element hinzugefügt wurde.
     */
    def addQualificationType(){
        def qualificationType
        try{
            qualificationType = qualificationTypeService.createQualificationType(params.type)
            if(qualificationType.save()){
                flash.message = message(code: 'default.created.qualificationType.message', args:[params.type])

            }
            else{
                flash.error = 'Something went wrong'
            }
        }
        catch(QualificationTypeException qte){
            flash.error = qte.message
        }
        def qualificationTypes = QualificationType.list()
        render template: 'qualificationTypesList', model: [qualificationTypes: qualificationTypes]
    }
    def addModuleType(String type){
        def moduleType
        try{
            moduleType = moduleTypeService.createModuleType(params.type)
            if(moduleType.save()){
                flash.message = message(code: 'default.created.moduleType.message', args:[params.type])
            }
        }
        catch(ModuleTypeException mte){
            flash.error = mte.message
        }
        def moduleTypes = ModuleType.list()
        render template: 'moduleTypesList', model: [moduleTypes: moduleTypes]
    }
    def addConnectionType(String type){
        def connectionType
        try{
            connectionType = connectionTypeService.createConnectionType(params.type)
            if(connectionType.save()){
                flash.message = message(code: 'default.created.connectionType.message', args:[params.type])
            }
        }
        catch(ConnectionTypeException cte){
            flash.error = cte.message
        }
        def connectionTypes = ConnectionType.list()
        render template: 'connectionTypesList', model: [connectionTypes: connectionTypes]
    }
    def addDataCategory(String category){
        def dataCategory
        try{
            dataCategory = dataCategoryService.createDataCategory(params.category)
            if(dataCategory.save()){
                flash.message = message(code: 'default.created.dataCategory.message', args:[params.category])
            }
        }
        catch(DataCategoryException dce){
            flash.error = dce.message
        }
        def dataCategories = DataCategory.list()
        render template: 'dataCategoriesList', model: [dataCategories: dataCategories]
    }
    def addComputerRole(String role){
        def computerRole
        try{
            computerRole = computerRoleService.createComputerRole(params.role)
            if(computerRole.save()){
                flash.message = message(code: 'default.created.computerRole.message', args:[params.role])
            }
        }
        catch(ComputerRoleException cre){
            flash.error = cre.message
        }
        def computerRoles = ComputerRole.list()
        render template: "computerRolesList", model: [computerRoles: computerRoles]
    }
}

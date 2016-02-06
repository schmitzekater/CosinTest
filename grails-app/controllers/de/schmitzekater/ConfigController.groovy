package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Controller to handle configuration of smaller Domain classes
 */
class ConfigController {
    def configService       /** Dependency Injection for the ConfigService  */

    def index() {
        redirect action: 'about'
    }

    def about() {}

    /*
    Method to change the language of all views via dropdown.
    Reloads the current URL with the selected language
     */
    def setLanguage(){
        def targetUri = params.targetUri ?: "/"
        session['language'] = params.lang
        redirect(uri: targetUri)
    }

    /*
    View that lists all smaller Domain Classes.
     */
    def config() {
        def qt = QualificationType.list()
        def cr = ComputerRole.list()
        def dc = DataCategory.list()
        def mt = ModuleType.list()
        def ct = ConnectionType.list()
        [qualificationTypes: qt, computerRoles: cr, dataCategories: dc, moduleTypes: mt, connectionTypes: ct]
    }

    /*
     * The following methods add entries to the smaller domain classes:
     * DataCategory
     * QualificationType
     * ModuleType
     * ConnectionType
     * ComputerRole
     * Site will be reloaded per AJAX requests upon change.
     */
    def addQualificationType(){
        def qualificationType
        try{
            qualificationType = configService.createQualificationType(params.type)
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
            moduleType = configService.createModuleType(params.type)
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
            connectionType = configService.createConnectionType(params.type)
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
            dataCategory = configService.createDataCategory(params.category)
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
            computerRole = configService.createComputerRole(params.role)
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

    /*
    The following methods provide editing of already existing smaller Domain class entries.
     */
    def updateComputerRole(){
        def computerRole = ComputerRole.findById(params.id)
        if(computerRole){
            computerRole.role = params.role
            if(computerRole.save(failOnError: true)){
                flash.message = message(code: 'default.updated.message', args: ['Computer Role', params.role])
            }
            else{
                flash.error = message(code: 'default.not.updated.message', args: ['Computer Role', computerRole.role])
            }
            redirect action: 'config'
        }
    }

    def updateDataCategory(){
        def dataCategory = DataCategory.findById(params.id)
        if(dataCategory){
            dataCategory.category = params.category
            if(dataCategory.save(failOnError: true)){
                flash.message = message(code: 'default.updated.message', args: ['Data Category', params.category])
            }
            else{
                flash.error = message(code: 'default.not.updated.message', args: ['Data Category', dataCategory.category])
            }
            redirect action: 'config'
        }
    }

    def updateConnectionType(){
        def connectionType = ConnectionType.findById(params.id)
        if(connectionType){
            connectionType.connection= params.connection
            if(connectionType.save(failOnError: true)){
                flash.message = message(code: 'default.updated.message', args: ['Connection Type', params.connection])
            }
            else{
                flash.error = message(code: 'default.not.updated.message', args: ['Connection Type', connectionType.connection])
            }
            redirect action: 'config'
        }
    }

    def updateModuleType(){
        def moduleType = ModuleType.findById(params.id)
        if(moduleType){
            moduleType.moduleType= params.type
            if(moduleType.save(failOnError: true)){
                flash.message = message(code: 'default.updated.message', args: ['Module Type', params.type])
            }
            else{
                flash.error = message(code: 'default.not.updated.message', args: ['Module Type', moduleType.moduleType])
            }
            redirect action: 'config'
        }
    }

    def updateQualificationType(){
        def qualificationType = QualificationType.findById(params.id)
        if(qualificationType){
            qualificationType.type = params.type
            if(qualificationType.save(failOnError: true)){
                flash.message = message(code: 'default.updated.message', args: ['Qualification Type', params.type])
            }
            else{
                flash.error = message(code: 'default.not.updated.message', args: ['Qualification Type', qualificationType.type])
            }
            redirect action: 'config'
        }
    }

    /*
    Render the views for all editing methods.
     */
    def editQualificationType (QualificationType type){
        respond type
    }
    def editModuleType (ModuleType type){
        respond type
    }
    def editConnectionType (ConnectionType type){
        respond type
    }
    def editComputerRole (ComputerRole role){
        respond role
    }
    def editDataCategory (DataCategory category){
        respond category
    }
}

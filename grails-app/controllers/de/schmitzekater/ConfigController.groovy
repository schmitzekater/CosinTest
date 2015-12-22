package de.schmitzekater

class ConfigController {
    def qualificationTypeService

    def index() {
        def qt = QualificationType.list()
        def cr = ComputerRole.list()
        def dc = DataCategory.list()
        def mt = ModuleType.list()
        def ct = ConnectionType.list()
        [qualificationTypes: qt, computerRoles: cr, dataCategories: dc, moduleTypes: mt, connectionsTypes: ct]
    }
    def addQualificationType(){
        def qualificationType
        try{
            qualificationType = qualificationTypeService.createQualificationType(params.type)
            if(qualificationType.save()){
                flash.message = message(code: 'default.created.message', args:['type'])
            }
        }
        catch(QualificationTypeException qte){
            flash.error = qte.message
        }
    }
    def addModuleType(String type){

    }
    def addConnectionType(String type){

    }
    def addDataCategory(String catagory){

    }
    def addComputerRole(String role){

    }
}

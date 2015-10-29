package de.schmitzekater

class User {
    String userId
    String password
    String signature
    Boolean isAdmin
    Boolean isReadOnly
    Date dateCreated
    Date lastPasswordChange

    static label = "Benutzer"
    static belongsTo = [person: Person]
    static constraints = {
        userId size: 6..25,  unique: true, nullable: false
        password size: 6..30, blank: false, nullable: false, validator: {passwd, user -> passwd != user.userId}
        signature size: 6..30, blank: false
        isAdmin nullable: true
        isReadOnly nullable: true
        person nullable: false
    }


}

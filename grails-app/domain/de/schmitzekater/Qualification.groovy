package de.schmitzekater


class Qualification {
    Date qualificationDate
    String comment
    File attachment

    //static auditable = true
    static belongsTo = [qualificationObject: QualifiableObject]
    static hasOne = [qualificationType: QualificationType]

    static constraints = {
        attachment nullable: true
        comment nullable: true, maxSize: 1000
        qualificationDate nullable: false, max: new Date()+1
        qualificationType nullable: false
        qualificationObject nullable: true
    }

    String getDisplayString(){
        def text = new StringBuilder()
        text += qualificationDate.format('dd-MMM-yyyy')
        text += ': '
        text += qualificationType.toString()
        text += ' '
        text += qualificationObject.getDisplayString()

        return text
    }

    String toString() {
        getDisplayString()
    }

}

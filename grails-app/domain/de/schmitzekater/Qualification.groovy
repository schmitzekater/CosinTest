package de.schmitzekater


class Qualification {

    public final static String[] types = ["Qualification", "Validation", "Calibration", "Periodic Review"]

    Date qualificationDate
    // String qualificationType
    String comment
    File attachment

    static auditable
    static belongsTo = [qualificationObject: QualifiableObject]
    static hasOne = [qualificationType: QualificationType]

    static constraints = {
        attachment nullable: true
        comment nullable: true
        qualificationDate nullable: false
        qualificationType nullable: false//, inList: types.toList()
        qualificationObject nullable: true
        // software nullable: true
        //module nullable: true
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

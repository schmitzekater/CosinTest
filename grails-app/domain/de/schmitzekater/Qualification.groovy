package de.schmitzekater

import java.sql.Blob

class Qualification {

    Date qualificationDate
    String qualificationType
    String comment
    Blob attachment

    static belongsTo = [software: Software, module: Module]

    static constraints = {
        attachment nullable: true
        comment nullable: true
        qualificationDate nullable: false
        qualificationType nullable: false, inList: ["Qualification", "Validation", "Calibration"]
        software nullable: true
        module nullable: true
    }
}

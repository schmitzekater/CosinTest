package de.schmitzekater

import java.sql.Blob

class Qualification {

    Date qualificationDate
    String qualificationType
    String comment
    Blob attachment

    static auditable
    static belongsTo = [software: Software, module: Module]

    static constraints = {
        attachment nullable: true
        comment nullable: true
        qualificationDate nullable: false
        qualificationType nullable: false, inList: ["Qualification", "Validation", "Calibration"]
        software nullable: true
        module nullable: true
    }

    String getDisplayString(){
        def text = new StringBuilder()
        text += qualificationDate.format('yyyyMMdd')
        text += ': '
        text += qualificationType
        text += ' '
        if(software) text += software.getDisplayString()
        if(module)   text += module.getDisplayString()
        return text
    }
}

package de.schmitzekater

import com.sun.xml.internal.fastinfoset.util.StringArray

import java.sql.Blob

class Qualification {

    public final static String[] types = ["Qualification", "Validation", "Calibration", "Periodic Review"]

    Date qualificationDate
    String qualificationType
    String comment
    File attachment

    static auditable
    static belongsTo = [qualificationObject: QualifiableObject]

    static constraints = {
        attachment nullable: true
        comment nullable: true
        qualificationDate nullable: false
        qualificationType nullable: false, inList: ["Qualification", "Validation", "Calibration"]
        qualificationObject nullable: true
        // software nullable: true
        //module nullable: true
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

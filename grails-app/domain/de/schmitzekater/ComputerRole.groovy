package de.schmitzekater

abstract class ComputerRole {
    public static final String DATABASE_SERVER = "Database Server"
    public static final String FILE_SERVER = "Fileserver"
    public static final String UNSPEC_SERVER = "Unspecified Server"
    public static final String UNCPEC_CLIENT = "Unspecified Client"
    public static final String ACQUISITION_CLIENT = "Acquisition Client"
    public static final String PROCESSING_SERVER = "Processing Server"
    public static final String APPLICATION_SERVER = "Application Server"
    public static final String COMMUNICATION_SERVER = "Communication Server"
    public static final String OFFICE_CLIENT = "Office Client"

    static belongsTo = [computer: Computer]

    static constraints = {
    }
}

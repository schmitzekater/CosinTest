package de.schmitzekater

abstract class DataCategory {
    public static final String CATEGORY_A = "Paper"
    public static final String CATEGORY_B = "Hybrid"
    public static final String CATEGORY_C = "Partly Compliant"
    public static final String CATEGORY_D = "Full Compliant"

    static belongsTo = [system: System]
    static constraints = {
    }
}

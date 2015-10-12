package de.schmitzekater

abstract class ModuleType {
    public static final String COLUMN_OVEN = "Column Oven"
    public static final String AUTOSAMPLER = "Autosampler"
    public static final String MASS_SPECTROMETER = "Mass Spectrometer"
    public static final String LC_PUMP_UNARY = "Unary LC Pump"
    public static final String LC_PUMP_BINARY = "Binary LC Pump"
    public static final String LC_PUMP_QUARTERNARY = "Quarternary LC Pump"
    public static final String DEGASSER = "Degasser"
    public static final String DETECTOR = "Detector"

    static belongsTo = [module: Module]
    static constraints = {
    }
}

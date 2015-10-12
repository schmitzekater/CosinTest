package de.schmitzekater

abstract class ConnectionType {
    public static final String SERIAL = "Serial"
    public static final String ETHERNET = "Ethernet"
    public static final String PARALLEL = "Parallel"
    public static final String IEEE = "IEEE"
    public static final String USB = "USB"

    static belongsTo = [module: Module]
    static constraints = {
    }
}

// Place your Spring DSL code here
import de.schmitzekater.CosinSecurityEventListener
import de.schmitzekater.CosinUserDetailsService

beans = {
    cosinSecurityEventListener(CosinSecurityEventListener)
    userDetailsService(CosinUserDetailsService)
}

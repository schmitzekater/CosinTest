// Place your Spring DSL code here
import de.schmitzekater.CosinSecurityEventListener
import de.schmitzekater.CosinUserDetailsService
import de.schmitzekater.UserService

beans = {
    cosinSecurityEventListener(de.schmitzekater.CosinSecurityEventListener) {
        userService = ref('userService')
    }
    userService(UserService) {}
    //userDetailsService(CosinUserDetailsService)
}

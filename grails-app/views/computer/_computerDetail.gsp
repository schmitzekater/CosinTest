<f:with bean="computer">
    <f:display property="computerName" wrapper="detail"/>
    <f:display property="computerVendor" wrapper="detail/link/vendor"/>
    <f:display property="installedSoftware" wrapper="detail"/>
    <g:render template="/computer/computerRolesDetail" model="${computer}"/>
</f:with>


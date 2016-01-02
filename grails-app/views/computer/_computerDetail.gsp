%{--<table class="table table-striped">
    <tbody>--}%
    <f:with bean="computer">
        <f:display property="computerName" wrapper="detail"/>
        <f:display property="computerVendor" wrapper="detail/link/vendor"/>
        <f:display property="computerRole" wrapper="detail"/>
        <f:display property="installedSoftware" wrapper="detail"/>
        <f:display property="system" wrapper="detail/link/system"/>
    </f:with>
%{--
    </tbody>
</table>--}%

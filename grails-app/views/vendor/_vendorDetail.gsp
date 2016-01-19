<table class="table table-striped">
    <tbody>
    <f:with bean="vendor">
        <f:display property="name" wrapper="detail"/>
        <f:display property="url" wrapper="detail"/>
        <f:display property="address.streetOne" wrapper="detail"/>
        <f:display property="address.streetTwo" wrapper="detail"/>
        <f:display property="address.zip" wrapper="detail"/>
        <f:display property="address.city" wrapper="detail"/>
        <f:display property="address.county" wrapper="detail"/>
        <f:display property="address.country" wrapper="detail"/>
    </f:with>

    </tbody>
</table>
<sec:link controller="vendor" id="${vendor.id}" action="edit">
    <span class="glyphicon glyphicon-pencil" style="color: orange" aria-hidden="true" title='<g:message
        code="edit.vendor"/>'>
</sec:link>
<td>
    <div class="btn-group-xs">
        <g:form controller = "${controllerName}" id="${model.id}">
            <g:actionSubmit action="edit" class="btn btn-primary"
                            value="${message(code: 'default.button.edit.miniLabel', default: 'Edit')}"/>
            <g:actionSubmit action="detail" class="btn btn-info" value="${message(code:'default.button.info.miniLabel', default: 'I')}"/>
        </g:form>
    </div>
</td>
<!-- template: _fields/edit/queries/person/supervisor/_widget.gsp -->
<g:select name="supervisor" from="${availableSupervisors}"
          optionKey="id" optionValue="${getDisplayString}" value="${department?.supervisor?.id}"
          noSelection="${['null': '<N/A>']}"></g:select>
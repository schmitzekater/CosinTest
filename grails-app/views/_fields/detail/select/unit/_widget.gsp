<!-- template: _fields/detail/select/unit/_widget.gsp -->
<g:select name="unit" from="${de.schmitzekater.Unit.getAvailableUnits()}"
          optionKey="id" optionValue="unitName" noSelection="${['null':'<N/A>']}"></g:select>
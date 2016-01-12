<!--suppress CheckTagEmptyBody -->
<!-- template: _fields/detail/select/computer/_widget.gsp -->
<g:select name="computer" from="${de.schmitzekater.Computer.all}"
          optionKey="id" optionValue="computerName" noSelection="${['null':'<N/A>']}"></g:select>
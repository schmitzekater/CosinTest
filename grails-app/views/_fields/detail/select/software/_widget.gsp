<!-- template: _fields/detail/select/software/_widget.gsp -->
<g:select name="software" from="${de.schmitzekater.Software.all}"
          optionKey="id" optionValue="softwareName" noSelection="${['null':'<N/A>']}"></g:select>
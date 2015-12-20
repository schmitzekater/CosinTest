
<dl>
    <g:each var="qualification" in="${model}">
        <dt>${qualification.qualificationDate.format('dd-MMM-yyyy')}</dt>
        <dd>${qualification.qualificationType}</dd>
        <dd>${qualification.comment}</dd>
    </g:each>
</dl>
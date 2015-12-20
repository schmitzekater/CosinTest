
<dl>
    <g:each var="qualification" in="${model}">
        <dt>${qualification.qualificationDate}</dt>
        <dd>${qualification.qualificationType}</dd>
        <dd>${qualification.comment}</dd>
    </g:each>
</dl>
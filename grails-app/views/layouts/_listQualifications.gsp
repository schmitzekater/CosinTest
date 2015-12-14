
<ul>
    <g:each var="qualification" in="${model}">
        <li>${qualification.getDisplayString()}</li>
    </g:each>
</ul>
<%@ page import="de.schmitzekater.*" %>
<table class="table table-striped">
    <thead>
    <tr>
        <g:sortableColumn property="id" title="${message(code: 'default.id.label', default:'Id')}" />
        <g:sortableColumn property="departmentName" title="${message(code: 'department.departmentName.label', default:'Department')}" />
        <g:sortableColumn property="supervisor" title="${message(code: 'department.supervisor.label', default:'Supervisor')}" />
        <th><a href="#"><g:message code='action.label'/></a></th>
    </tr>
    </thead>
    <tbody>
    <g:each var="department" in="${model}">
       <tr>
            <f:with bean="${department}">
                <f:display property="id" wrapper="list"/>
                <f:display property="departmentName" wrapper="list"/>
                <f:display property="supervisor" wrapper="list/link/person" />
            </f:with>
           <td>
               <g:render template="/layouts/editInfoButtons" model="[model: department]"/>
           </td>
        </tr>
    </g:each>
    </tbody>
</table>
<g:render template="/layouts/addPaginateButtons"/>
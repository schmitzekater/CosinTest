%{--Schrecklicher Hack, aber er funktioniert. Quelle: http://stackoverflow.com/questions/30623429/grails-how-to-use-exists-notexists-within-createcriteria
    Das Ganze wäre viel sauberer, wenn es im Controller aufgehoben werden. Aber immherin, es klappt. ;)--}%
<!-- template: _fields/edit/queries/person/_widget.gsp -->
<%@ page import="de.schmitzekater.Person" %>
<g:select name="person" from="${de.schmitzekater.Person.createCriteria().list(){sqlRestriction('''
                                            not exists (select 1 from Person p inner join User u on p.id = u.person_id where u.person_id = this_.id) ''')}}"
          optionKey="id" optionValue="lastName" noSelection="${['null':'<N/A>']}"></g:select>
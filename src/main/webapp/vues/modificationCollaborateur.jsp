<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="modificationCollaborateur.titre"/></title>
    </head>
    <body>
        <form:form method="post" modelAttribute="modificationCollaborateur" action="modifierCollaborateur">
            <table border="1">
                <thead>
                    <tr>
                    	<th style="display: none;"><spring:message code="collaborateur.id"/></th>
                        <th><spring:message code="collaborateur.nom"/></th>
                        <th><spring:message code="collaborateur.prenom"/></th>
                       	<th><spring:message code="collaborateur.dateEntree"/></th>
		                <th><spring:message code="collaborateur.numeroTelephone"/></th>
		                <th><spring:message code="collaborateur.email"/></th>
		                <th><spring:message code="collaborateur.photo"/></th>
                    </tr>
                </thead>
                <tbody>           
                    <tr>
                        <td style="display: none;">
                        	<input type="hidden" name="collaborateur.id" value="${modificationCollaborateur.collaborateur.id}"/>
                        </td>  
                        <td>
                            <input type="text" name="collaborateur.nom" value="${modificationCollaborateur.collaborateur.nom}"/>
                            <b><i><form:errors path="collaborateur.nom" /></i></b>
                        </td>
                        <td>
                            <input type="text" name="collaborateur.prenom" value="${modificationCollaborateur.collaborateur.prenom}"/><br/>
                            <b><i><form:errors path="collaborateur.prenom" /></i></b>
                        </td>
                        <td>
                            <input type="date" name="collaborateur.dateEntree" value="${modificationCollaborateur.collaborateur.dateEntree}"/><br/>
                            <b><i><form:errors path="collaborateur.dateEntree" /></i></b>
                        </td>
                        <td>
                            <input type="tel" name="collaborateur.numeroTelephone" value="${modificationCollaborateur.collaborateur.numeroTelephone}"/><br/>
                            <b><i><form:errors path="collaborateur.numeroTelephone" /></i></b>
                        </td>                        
                        <td>
                            <input type="email" name="collaborateur.email" value="${modificationCollaborateur.collaborateur.email}"/><br/>
                            <b><i><form:errors path="collaborateur.email" /></i></b>
                        </td>                       
                    </tr>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>
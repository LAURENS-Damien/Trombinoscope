<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="listeCollaborateurs.titre"/></title>
    </head>
    <body>
    	<c:url value="/creationCollaborateur" var="urlCreation"></c:url>
        <a href="${urlCreation}">
            <spring:message code="creationCollaborateur.titre" />
        </a><br><br>
    	<c:choose>    	
	    	<c:when test="${!empty listeCollaborateurs}">
		        <table border="1">
		            <thead>
		                <tr>
		                    <th><spring:message code="collaborateur.nom"/></th>
		                    <th><spring:message code="collaborateur.prenom"/></th>	                    
		                    <th><spring:message code="collaborateur.dateEntree"/></th>
		                    <th><spring:message code="collaborateur.numeroTelephone"/></th>
		                    <th><spring:message code="collaborateur.email"/></th>
		                    <th><spring:message code="collaborateur.photo"/></th>
		                </tr>
		            </thead>
		            <tbody>	            
		                <c:forEach items="${listeCollaborateurs}" var="collaborateur">
		                    <tr>
		                        <td><c:out value="${collaborateur.nom}"/></td>
		                        <td><c:out value="${collaborateur.prenom}"/></td>
		                        <td><c:out value="${collaborateur.dateEntree}"/></td>
		                        <td><c:out value="${collaborateur.numeroTelephone}"/></td>
		                        <td><c:out value="${collaborateur.email}"/></td>
		                        <td><img src="data:image/png;base64,${collaborateur.photoFormatee}" width="200" height="150"/></td>
		                        <td>
		                            <c:url value="/modificationCollaborateur" var="urlModification">
		                                <c:param name="idCollaborateur" value="${collaborateur.id}"/>
		                            </c:url>
		                            <a href="${urlModification}">
		                                <spring:message code="listeCollaborateurs.modification" />
		                            </a>
		                        </td>
		                        <td>
		                            <c:url value="/supprimerCollaborateur" var="urlSuppression">
		                                <c:param name="idCollaborateur" value="${collaborateur.id}"/>
		                            </c:url>
		                            <a href="${urlSuppression}">
		                                <spring:message code="listeCollaborateurs.suppression" />
		                            </a>
		                        </td>
		                    </tr>
		                </c:forEach>	                
		            </tbody>
		        </table>
	        </c:when>
	        <c:otherwise>
	        	<spring:message code="listeCollaborateurs.empty"/>
	        </c:otherwise>
	    </c:choose>
    </body>
</html>
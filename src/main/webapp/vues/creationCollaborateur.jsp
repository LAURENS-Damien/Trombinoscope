<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="creationCollaborateur.titre"/></title>
    </head>
    <body>
        <form:form method="post" enctype="multipart/form-data" modelAttribute="creationCollaborateur" action="creerCollaborateur">
        	<spring:message code="collaborateur.nom" />
            <form:input path="nom"/>
            <b><i><form:errors path="nom" cssclass="error"/></i></b><br>
            
            <spring:message code="collaborateur.prenom"/>
            <form:input path="prenom"/>
            <b><i><form:errors path="prenom" cssclass="error"/></i></b><br>
            
            <spring:message code="collaborateur.poste" />
            <form:input path="poste"/>
            <b><i><form:errors path="poste" cssclass="error"/></i></b><br>
    
            <spring:message code="collaborateur.dateEntree" />
            <form:input type="date" path="dateEntree"/>
            <b><i><form:errors path="dateEntree" cssclass="error"/></i></b><br>
            
            <spring:message code="collaborateur.numeroTelephone" />
            <form:input path="numeroTelephone"/>
            <b><i><form:errors path="numeroTelephone" cssclass="error"/></i></b><br>
            
            <spring:message code="collaborateur.email" />
            <form:input path="email"/>
            <b><i><form:errors path="email" cssclass="error"/></i></b><br>           
                        
            <spring:message code="collaborateur.photo"/>
            <form:input path="photo" type="file"/>
            <b><i><form:errors path="photo" cssclass="error"/></i></b><br>
            
            <input type="submit"/>
        </form:form>
    </body>
</html>
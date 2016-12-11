<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.listecomptes"/></title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.identifiant"/></th>
                    <th><spring:message code="colonne.nom"/></th>
                    <th><spring:message code="colonne.balance"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listeComptes}" var="compte">
                    <tr>
                        <td><c:out value="${course.id}"/></td>
                        <td><c:out value="${course.nom}"/></td>
                        <td><c:out value="${course.balance}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
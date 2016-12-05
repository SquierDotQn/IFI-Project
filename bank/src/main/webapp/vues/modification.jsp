<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.creation.comptes"/></title>
    </head>
    <body>
        <form:form method="post" modelAttribute="modification" action="modifierModificationComptes">
            <table border="1">
                <thead>
                    <tr>
                        <th><spring:message code="colonne.identifiant"/></th>
                        <th><spring:message code="colonne.nom"/></th>
                        <th><spring:message code="colonne.balance"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${modification.listeComptes}" var="compte" varStatus="status">
                        <tr>
                            <td>
                                <c:out value="${compte.id}"/>
                                <input type="hidden" name="listeComptes[${status.index}].id" value="${compte.id}"/>
                            </td>
                            <td>
                                <c:out value="${compte.nom}"/>
                                <input type="hidden" name="listeComptes[${status.index}].nom" value="${compte.nom}"/>
                            </td>
                            <td>
                                <input type="text" name="listeComptes[${status.index}].balance" value="${compte.balance}"/><br/>
                                <b><i><form:errors path="listeComptes[${status.index}].balance" /></i></b>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>
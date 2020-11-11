<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
    <h1 style="text-align: center;color: green;">The ${operation} Are::</h1>
    
    <br>
    <b><a href="welcome"> Home</a></b>
    <br>
    <br>
    <c:choose>
    	<c:when test="${countries ne null && !empty countries}">
    		<table bgcolor="cyan" align="center">
    		<tr>
    		<td><b>Total ::${size}</b></td>
    		</tr>
	    		<c:forEach items="${countries}" var="country">
	    			<tr>
	    				<td style="color:red">${country}</td>
	    			</tr>
	    		</c:forEach>
    		</table>
    	</c:when>
    	<c:otherwise>
    		<b style="color:red;text-align:center">No records found</b>
    	</c:otherwise>
    </c:choose>
    
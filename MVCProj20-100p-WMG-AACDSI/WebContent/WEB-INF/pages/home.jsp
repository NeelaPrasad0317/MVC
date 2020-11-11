<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<h1 style="color:blue;text-align: center;">Welcome</h1>
	<h3 style="text-align: center;"><a href="wish">GetWish</a></h3>
	<br>
	<c:if test="${msg ne null && !empty msg}">
		<h1 style="color:green;text-align: center;">${msg}</h1>
	</c:if>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    
    <h1 style="text-align: center;color: green;">${wish}</h1>
    <BR>
    
    <b><a href="welcome"> Home</a></b>
    <br>
	
	<img src="/WEB-INF/images/home1.jpg"> 		<!-- wrong -->
	
    <img src='<c:url value="/images/home1.jpg"/>' />    
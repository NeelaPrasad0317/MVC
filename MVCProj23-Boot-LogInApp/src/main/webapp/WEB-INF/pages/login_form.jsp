<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: red;text-align: center;font-style: italic;font-family: comic sans MS;text-decoration: underline;">LogIn Form</h1>

<br>

<frm:form modelAttribute="user">
	<c:choose>
	<c:when test="${user ne null && !empty user}">
	<table align="center" bgcolor="cyan">
		<tr>	<td>UserName::</td><td><frm:input path="uname"/></td>	<tr>
		<tr>	<td>Password::</td><td><frm:input path="pwd"/></td>	<tr>
		<tr>	<td><input type="submit" value="LogIn"></td><td><input type="reset" value="Clear"></td>	<tr>
	</table>	
	</c:when>
	</c:choose>
</frm:form>
<br>
<c:if test="${result ne null && !empty result}">
	<h2 style="color: blue;text-align: center">${result}</h2>	
</c:if>

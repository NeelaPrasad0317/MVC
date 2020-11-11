<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

	<h1 style="text-align: center;color: red;text-decoration:underline;"><b >StudentForm</b></h1>
<frm:form modelAttribute="student" method="get">

	<table align="center" bgcolor="cyan">
		<tr>
			<td>Student No::</td><td><frm:input  path="sno"/></td>
		</tr>
		<tr>
			<td>Student Name::</td><td><frm:input  path="sname"/></td>
		</tr>
		<tr>
			<td>Student Add::</td><td><frm:input  path="sadd"/></td>
		</tr>
		<tr>
			<td>Student Avg::</td><td><frm:input  path="avg"/></td>
		</tr>
	
		<tr>
			<td><input type="submit" value="register"></td><td><input type="reset" value="clear"></td>
		</tr>
	
	</table>
	

</frm:form>
 
 
    
    
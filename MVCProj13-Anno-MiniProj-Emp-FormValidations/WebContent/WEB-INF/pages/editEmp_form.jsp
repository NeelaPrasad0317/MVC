<%@ page language="java" %>

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 	rel="stylesheet">
	
	<script type="text/javascript" src="js/validations.js"></script>
</head>
    
 <h1 style="color:red;text-align: center;text-shadow: black;text-decoration: underline;">Edit Form</h1>
<br >   
<frm:form modelAttribute="emp" onsubmit="return validation(this)">
	<table align="center"  class=" table-striped table-dark table-bordered table-sm ">
		<tr><td>Employee No</td>
				<td><frm:input path="empNo"  disabled="true"/>
		<tr><td>Employee Name</td>
				<td><frm:input path="ename"/><frm:errors cssClass="text-danger" path="ename"/><span id="enameid"></span></td></tr>
		<tr><td>Employee Job</td>
				<td><frm:input path="job" /><frm:errors cssClass="text-danger" path="job"/><span id="jobid"></span></td></tr>
		<tr><td>Employee Salary</td>
				<td><frm:input path="sal"/><frm:errors cssClass="text-danger" path="sal"/><span id="salid"></span></td></tr>
		<tr><td>Employee deptNo</td>
					<td><frm:select path="deptNo">
							<frm:options items="${deptNos}"/>
							</frm:select></td>
							</tr>
		<tr><td><input type="submit" value="Update"/></td><td><input type="reset" value="clear"></td></tr>					
	</table>
	<frm:hidden path="valid"/>
</frm:form>
    
    
    
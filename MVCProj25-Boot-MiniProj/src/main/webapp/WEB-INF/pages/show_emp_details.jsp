<%@ page language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<script type="text/javascript" src="js/show_emp_details.js"></script>
	
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 	rel="stylesheet">
</head>

<h1 style="color:red;text-align: center;text-shadow: black;text-decoration: underline;">Employees List</h1>
<br >
<h2 style="color:green"> <a href="welcome.htm"><img src="images/home1.jpg" height="60px" width="60px"></a></h2>
<br>

<div class="container">
<!-- //empNo,ename,job,salary,deptNo,netSalary,grossSalary---dto -->
<c:choose >
	<c:when test="${emp_details ne null && !empty  emp_details}">
		<table   class="table table-striped table-dark table-bordered table-sm ">
			<thead class="thead-light">
			<tr class="table-secondary" >
				<th scope="col">SL.NO</th>		
				<th scope="col">EmpNo</th>		
				<th scope="col">Name</th>		
				<th scope="col">Job</th>		
				<th scope="col">DeptNo</th>		
				<th scope="col">Salary</th>		
				<th scope="col">NetSalary</th>		
				<th scope="col">GrossSalary</th>
				<th>Options</th>		
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${emp_details}" var="emp">
				<tr align="justify" >
				<!-- //empNo,ename,job,salary,deptNo,netSalary,grossSalary---dto -->
					<td scope="row" style="text-align: center;" >${emp.slno}</td>
					<td scope="row" style="text-align: center;">${emp.empNo}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.deptNo}</td>
					<td>${emp.sal}</td>
					<td>${emp.netSalary}</td>
					<td>${emp.grossSalary}</td>
					<td><a href="editEmp.htm?empNo=${emp.empNo}"><img src="images/edit1.jpg" height="40px" width="40px"></a>
							&nbsp;&nbsp;&nbsp;
							<a href="deleteEmp.htm?empNo=${emp.empNo}" onclick="JavaScript:confirmation(${emp.empNo})"><img src="images/delete1.jpg" height="40px" width="40px"></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:when>
</c:choose>
</div>

	<c:if test="${msg ne null && !empty msg}">
		<marquee direction="left" bgcolor="red">${msg}</marquee>
	</c:if>

<h6 style="text-align: center;">
			<a href="JavaScript:doPrint()"><img src="images/print1.jpg" height="60px" width="60px"></a>
			<a href="addEmp.htm"><img src="images/add1.jpg" height="60px" width="60px"></a>
</h6>

<script type="text/javascript" src="js/show_emp_details.js"></script>


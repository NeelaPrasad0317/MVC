<%@ page language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 	rel="stylesheet">
</head>

<h1 style="color:red;text-align: center;text-shadow: black;text-decoration: underline;">Employees List</h1>
<br >
<h2 style="color:green"> <a href="welcome">Home</a>.</h2>
<br>
<div class="container">
<!-- //empNo,ename,job,salary,deptNo,netSalary,grossSalary---dto -->
<c:choose >
	<c:when test="${emp_details ne null && !empty  emp_details}">
		<table align="center"  class="table table-striped table-dark table-bordered table-sm ">
			<thead class="thead-light">
			<tr class="table-secondary">
				<th scope="col">EmpNo</th>		
				<th scope="col">Name</th>		
				<th scope="col">Job</th>		
				<th scope="col">DeptNo</th>		
				<th scope="col">Salary</th>		
				<th scope="col">NetSalary</th>		
				<th scope="col">GrossSalary</th>		
			</tr>
			</thead>
			<c:forEach items="${ emp_details}" var="emp">
				<tr >
				<!-- //empNo,ename,job,salary,deptNo,netSalary,grossSalary---dto -->
					<td scope="row">${emp.empNo}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.deptNo}</td>
					<td>${emp.salary}</td>
					<td>${emp.netSalary}</td>
					<td>${emp.grossSalary}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>
</div>

<h6 style="text-align: center;"><a href="JavaScript:doPrint()">Print</a>
</h6>
<br>
<br>
<br>
<script type="text/javascript">
	function doPrint(){
		frames.focus();
		frames.print();
	}
</script>

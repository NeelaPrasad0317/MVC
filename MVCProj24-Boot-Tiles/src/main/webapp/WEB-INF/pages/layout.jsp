<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
	<title><tiles:insertAttribute name="title"/></title>
</head>

<table height="100%" width="100%">
  
  <tr >
    <td colspan="2" height="100px" bgcolor="LightGray">
    	<tiles:insertAttribute name="header"/>
    </td>
  </tr>
  
  
  <tr align="center" height="70%">
  	<td colspan="1" width="20%" height="50" bgcolor="cyan" >
  		<tiles:insertAttribute name="menu"/>
  	</td>
  	<td colspan="1" width="80%"  align="left" background="<c:url value='/images/nareshitlogo.png'/>">	
  		<tiles:insertAttribute name="body"/>
  	</td> 
  </tr>
  
  
  <tr >
    <td colspan="2" height="70px" bgcolor="silver" style="text-align: center;">
    	<tiles:insertAttribute name="footer"/>
    </td>
  </tr>
</table>

<%-- <img src="<c:url value='/images/nareshitlogo.png'/>"> --%>
    
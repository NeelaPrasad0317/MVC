<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <h1 style="text-align: center;color: green;"><u>All Contries</u></h1>
    <BR>
    
    <b><a href="welcome.htm"> Home</a></b>
    <br>

    countries::${countries}
    <%
//     java.lang.String[] cons=(String[])request.getAttribute("countries");
    String[] cons=(String[]) pageContext.findAttribute("countries");
    for(int i=1;i<cons.length;i++){
	%>
	<br><%=i+". "+cons[i] %>
	<%

    }
     %>
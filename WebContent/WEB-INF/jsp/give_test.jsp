<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="eval" method="post">
	<h3 align="center">Examination Questions</h3>
	<tr><h3>Each Question contains one mark. Each Question is of type multiple choice question.</h3></tr>
	<br>
	
	<c:forEach var="q" items="${list}">
	<tr>
	<h3>${q.id}. ${q.que} </h3>
	
	<input type="radio" id="op1" name="${q.id }" value="${q.op1 }">
    <label for="op1">${q.op1 }</label><br>
    
    <input type="radio" id="op2" name="${q.id }" value="${q.op2 }">
    <label for="op2">${q.op2 }</label><br>
    
    <input type="radio" id="op3" name="${q.id }" value="${q.op3 }">
    <label for="op3">${q.op3 }</label><br>
    
    <input type="radio" id="op4" name="${q.id }" value="${q.op4 }">
    <label for="op4">${q.op4 }</label><br><br>
	</tr>
	</c:forEach>
	
	<input type="submit" value="submit"  name="submit" >
	</form>
	

</body>
</html>
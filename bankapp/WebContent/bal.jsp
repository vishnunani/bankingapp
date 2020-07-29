<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/bankingapp" user="root" password="root"/>
<sql:query var="rs" dataSource="${db}">select * from accounts</sql:query>
<c:forEach items="${rs.rows}" var="i" > 
THE ACCOUNT BALANCE IS : <c:out value="${i.amount}"></c:out>
</c:forEach>
<a href="Home.jsp">Home</a>
</body>
</html>
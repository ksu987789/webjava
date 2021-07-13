<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>aaa</title>
</head>
<body>
	<form method="post" action="${contextPath }/member/joinMember.do">
	<p>id : <input type="text" name="id"/></p>
	<p>pw : <input type="text" name="pw"/></p>
	<p>name : <input type="text" name="name"/></p>
	<p>phone : <input type="text" name="phone"/></p>
	<p>address : <input type="text" name="address"/></p>
	<p>email : <input type="text" name="email"/></p>
	
	<p><input type="submit" value="전송"/></p>
</body>	
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>test3</title>
</head>
<body>
	<form action="/spring/test3" method=get>
		<h1>테스트3</h1>
		<input type="text" name="id" value="${num1}" placeholder="id"><br>
		<input type="password" name="pw" value="${num2}" placeholder="pw"><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>

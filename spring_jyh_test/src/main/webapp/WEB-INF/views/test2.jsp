<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>test2</title>
</head>
<body>
	<form action="/spring/test2/form" method=get>
		<h1>테스트2</h1>
		<input type="text" name="num1" value="${num1}" placeholder="정수입력"><br>
		<input type="text" name="num2" value="${num2}" placeholder="정수입력"><br>
		<input type="text" readonly value="${result}"> <br>
		<button type="submit">전송</button>
	</form>
</body>
</html>

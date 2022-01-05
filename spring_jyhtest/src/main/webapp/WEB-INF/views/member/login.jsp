<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="container" action="<%= request.getContextPath()%>/login" method="post">
		<h1>로그인</h1>
		<div class="form-group">
		  <label for="usr">ID:</label>
		  <input type="text" class="form-control" name="me_id">
		</div>
		<div class="form-group">
		  <label for="pwd">Password:</label>
		  <input type="password" class="form-control" name="me_pw">
		</div>
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
</body>
</html>
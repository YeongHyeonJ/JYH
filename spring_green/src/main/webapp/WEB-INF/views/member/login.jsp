<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>로그인</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="body">
		<div class="container">
			<h1 class="text-center">로그인</h1>
			<form action="<%=request.getContextPath()%>/login" method="post">
				<div class="form-group">
				  <input type="text" class="form-control" name="me_id">
				</div>
				<div class="form-group">
				  <input type="password" class="form-control" name="me_pw">
				</div>
				<button class="btn btn-outline-success col-12">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="<%=request.getContextPath() %>/">HOME</a>
	  <ul class="navbar-nav">
		<c:if test="${user == null }">
			<!-- Links -->
			<li class="nav-item">
		    	<a class="nav-link" href="<%=request.getContextPath() %>/login">로그인</a>
		    </li>
		    <li class="nav-item">
		    	<a class="nav-link" href="<%=request.getContextPath() %>/signup">회원가입</a>
		    </li>
		</c:if>
		<c:if test="${user != null }">
			<!-- Links -->
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath() %>/logout">로그아웃</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath() %>/mypage">마이페이지</a>
			</li>
		</c:if>
		<li class="nav-item">
			<a class="nav-link" href="<%=request.getContextPath() %>/board/list?type=공지">공지사항</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<%=request.getContextPath() %>/board/list">게시글</a>
		</li>
		<c:if test="${user.me_authority == '슈퍼 관리자'}">
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath() %>/admin/member/list">회원관리</a>
			</li>
		</c:if>
	  </ul>
	</nav>
</body>
</html>
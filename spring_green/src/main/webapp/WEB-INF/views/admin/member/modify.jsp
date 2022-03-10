<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="body container">
<h1>회원관리</h1>
<table class="table table-primary table-hover">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이메일</th>
        <th>권한</th>
      </tr>
    </thead>
    <tbody>
	    <c:forEach items="${list}" var="member">
	      <tr>
	        <td class="me_id">${member.me_id}</td>
	        <td class="me_email">${member.me_email}</td>
	        <td class="form-group">
	        	<select class="form-control me_authority">
	        		<option <c:if test="${member.me_authority == '회원'}">selected</c:if>>회원</option>
	        		<option <c:if test="${member.me_authority == '관리자'}">selected</c:if>>관리자</option>
	        	</select>
	        </td>
	      </tr>
	    </c:forEach>
	</tbody>
  </table>
</div>


<script>
	$('.me_authority').change(function(){
		var me_id = $(this).parents('tr').find('.me_id').text();
		var me_authority = $(this).parents('tr').find('.me_authority').val();
		var member = {
			me_id		: me_id,
			me_authority: me_authority
		};
		console.log(member);
		$.ajax({
			async:false,
			type:'POST',
			data: JSON.stringify(member),
			url: '<%=request.getContextPath()%>/admin/change/authority',
			contentType:"application/json; charset=UTF-8",
			success : function(res){
				console.log(res);
			}
		});
	});

</script>

</body>
</html>
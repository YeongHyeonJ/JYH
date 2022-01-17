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
	<form class="body container" action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
		<div class="form-group">
			<input type="text" class="form-control" name="bd_title" value="${board.bd_title}">
		</div>
		<div class="form-group">
			<textarea class="form-control" name="bd_contents"  rows="10" >${board.bd_contents}</textarea>
		</div>
		<div class="form-group attachment">
			<label>첨부파일(최대 3개)</label>
			<c:forEach items="${fileList}" var="file">			
				<div class="form-control">
					<input type="hidden" name="fileNums" value="${file.fi_num}">	
					<span>${file.fi_ori_name}</span>
					<a class="btn-close" href="#">x</a>
				</div>
			</c:forEach>
			<c:forEach begin="1" end="${3-fileList.size() }">
				<input type="file" class="form-control" name="files" >	
			</c:forEach>
		</div>
		
		<input type="hidden" name="bd_num" value="${board.bd_num}">
		<button class="btn btn-outline-success col-12">수정</button>
	</form>
	<script type="text/javascript">
		$(function(){
			$('.attachment .btn-close').click(function(e) {
				e.preventDefault();
				$(this).parent().remove();
				var str = '<input type="file" class="form-control" name="files" >';
				$('.attachment').append(str);
			})
		})
	
	</script>
</body>
</html>
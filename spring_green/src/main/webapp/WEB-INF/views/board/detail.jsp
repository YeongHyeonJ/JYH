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
		<c:if test="${board != null}">
			<c:if test="${board.bd_type == 'NORMAL'}">
				<h1>게시글 상세</h1>
			</c:if>
			<c:if test="${board.bd_type != 'NORMAL'}">
				<h1>게시글 상세</h1>
			</c:if>
			<div class="form-group">
				<input type="text" class="form-control" name="bd_title"  readonly value="${board.bd_title}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="bd_me_id"  readonly value="${board.bd_me_id}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="bd_reg_date"  readonly value="${board.bd_reg_date_str}">
			</div>
			<div class="form-group">
				<div class="form-control" style="min-height:300px; height:auto;">${board.bd_contents}</div>
			</div>
			<div class="form-group">
				<c:if test="${files != null && files.size() != 0}">
					<label>첨부파일</label>
					<c:forEach items="${files}" var="file">
					<a href="<%=request.getContextPath() %>/board/download?fileName=${file.fi_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
				</c:if>
				<c:if test="${files == null || files.size() == 0 }">
					<label>첨부파일 없음</label>
				</c:if>
			</div>
			<c:if test="${user != null && user.me_id == board.bd_me_id}">
				<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">수정</button>
				</a>
				<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">삭제</button>
				</a>
				
			</c:if>
			<c:if test="${board.bd_type != '공지' && board.bd_num == board.bd_ori_num }">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
					<button class="btn btn-outline-success">답글</button>
				</a>
			</c:if>	
		</c:if>
		<c:if test="${board == null}">
				<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
			</c:if>
		<hr class="mt-3">
		<div class="comment-box mt-3">
			<div class="input-group mb-3">
				<textarea class="form-control co_contents" rows="3" placeholder="댓글입력"></textarea>
				<div class="input-group-append">
					<button class="btn btn-outline-success btn-comment-insert">등록</button>
				</div>
			</div>
		</div>
	</div>
	<script>
	var contextPath = '<%=request.getContextPath()%>';
	$(function(){
			$('.btn-comment-insert').click(function(){
				//유저의 id를 가져온다.
				var co_me_id = '${user.me_id}';
				//console.log(co_me_id);
				//id가 없을경우 알람.
				if(co_me_id==''){
					alert('댓글은 로그인 후 가능합니다.');
					return;
				}
				var co_contents = $('.co_contents').val();
				var co_bd_num = '${board.bd_num}';
				var comment = {
						co_me_id 	: co_me_id,
						co_contents : co_contents,
						co_bd_num 	: co_bd_num
				};
				$.ajax({
			        async:false,
			        type:'POST',
			        data:JSON.stringify(comment),
			        url: contextPath + "/comment/insert",
			        contentType:"application/json; charset=UTF-8",
			        success : function(res){
			            if(res){
			            	alert('댓글등록이 완료 되었습니다.');
			            	$('.co_contents').val('');
			            }else{
			            	alert('댓글등록에 실패 했습니다.')
			            }
			        }
			    });
			});
		});
	</script>
</body>
</html>
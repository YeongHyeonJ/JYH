<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comment.js"></script>
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
		
		<div class="comment-list">
			<div class="comment-box clearfix">
				<div class="float-left" style="width:24px">┗</div>
				<div class=" float-left" style="width: calc(100% - 24px)">
					<div class="co_me_id">qwe</div>
					<div class="co_contents mt-2">댓글 내용</div>
					<div class="co_reg_date mt-2">2022-01-24</div>
					<button class="btn-rep-comment btn btn-outline-success">답글</button>
					<button class="btn-mod-comment btn btn-outline-dark">수정</button>
					<button class="btn-del-comment btn btn-outline-danger">삭제</button>
				</div>
				<hr class="float-left mt-3" style="width:100%">
			</div>
		</div>
		
		<div class="comment-box mt-3">
			<div class="input-group mb-3">
				<textarea class="form-control co_contents" rows="3" placeholder="댓글입력"></textarea>
				<div class="input-group-append">
					<button class="btn btn-outline-success btn-comment-insert">등록</button>
				</div>
			</div>
		</div>
		
		<hr class="mt-3">
	</div>
	<script>
	var contextPath = '<%=request.getContextPath()%>';
	commentService.setContextPath(contextPath);
	console.log(commentService.name);
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
				commentService.insert(comment, '/comment/insert', function(res){
					if(res){
		            	alert('댓글등록이 완료 되었습니다.');
		            	$('.co_contents').val('');
		            }else{
		            	alert('댓글등록에 실패 했습니다.')
		            }
				})
			});
			
			$.ajax({
		        async:false,
		        type:'get',
		        url:contextPath + "/comment/list?page=1&bd_num=" + '${board.bd_num}',
		        dataType:"json",
		        success : function(res){
		            console.log(res);
		        }
		    });
			
		});
		function createComment(comment, me_id){
			
			var str = '';
						
			str+=	'<div class="comment-box clearfix">'
			if(comment.co_ori_num != comment.co_num){
			str+=		'<div class="float-left" style="width:24px">┗</div>'
			str+=		'<div class=" float-left" style="width: calc(100% - 24px)">'
			}else{
			str+=		'<div class=" float-left" style="width: 100%">'	
			}
			str+=			'<div class="co_me_id">'+comment.co_me_id+'</div>'
			str+=			'<div class="co_contents mt-2">'+comment.co_contents+'</div>'
			str+=			'<div class="co_reg_date mt-2">'+comment.co_reg_date+'</div>'
			if(comment.co_ori_num == comment.co_num)
			str+=			'<button class="btn-rep-comment btn btn-outline-success">답글</button>'
			if(comment.co_me_id == me_id){
			str+=			'<button class="btn-mod-comment btn btn-outline-dark">수정</button>'
			str+=			'<button class="btn-del-comment btn btn-outline-danger">삭제</button>'
			}
			str+=		'</div>'
			str+=		'<hr class="float-left mt-3" style="width:100%">'
			str+=	'</div>'
			return str;
		}
	</script>
</body>
</html>
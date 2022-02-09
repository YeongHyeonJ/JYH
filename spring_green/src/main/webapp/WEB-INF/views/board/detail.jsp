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
			
			<div class="likes-btn-box mb-3">
				<button class="btn btn-outline-primary btn-up" data-value="1">추천</button>
				<button class="btn btn-outline-danger btn-down" data-value="-1">비추천</button>
			</div>
			
			
			<c:if test="${user != null && user.me_id == board.bd_me_id}">
				<a href="<%=request.getContextPath()%>/board/modify?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">수정</button>
				</a>
				<a href="<%=request.getContextPath()%>/board/delete?bd_num=${board.bd_num}">
					<button class="btn btn-outline-success">삭제</button>
				</a>
				
			</c:if>
			<!-- 현재 보고 있는 게시글이 원본 게시글 -->
			<c:if test="${board.bd_num == board.bd_ori_num && (board.bd_type == 'NORMAL' || board.bd_type == '질문')}">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_num}">
					<button class="btn btn-outline-success">답변</button>
				</a>
			</c:if>
			<!-- 현재 보고 있는 게시글이 답변 게시글 -->
			<c:if test="${board.bd_num != board.bd_ori_num && (board.bd_type == 'NORMAL' || board.bd_type == '질문')}">
				<a href="<%=request.getContextPath()%>/board/register?bd_ori_num=${board.bd_ori_num}">
					<button class="btn btn-outline-success">답변</button>
				</a>
			</c:if>
		</c:if>
		<c:if test="${board == null}">
				<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:if>
		
		<div class="comment-list mt-3">
			댓글장소
		</div>
		<div class="comment-pagination">
		
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
<script type="text/javascript">
var contextPath = '<%=request.getContextPath()%>';
commentService.setContextPath(contextPath);
//console.log(commentService.contextPath);
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
		var co_contents = $('textarea.co_contents').val();
		var co_bd_num = '${board.bd_num}';
		var comment = {
				co_me_id 	: co_me_id,
				co_contents : co_contents,
				co_bd_num 	: co_bd_num
		};
		
		if(co_contents == ''){
			alert('댓글을 입력하세요.');
			return;
		}
		commentService.insert(comment, '/comment/insert',insertSuccess);
	});
	
	/*
	$.ajax({
	       async:false,
	       type:'get',
	       url:contextPath + "/comment/list?page=1&bd_num=" + '${board.bd_num}',
	       dataType:"json",
	       success : function(res){
	          	var str= '';
	          	var me_id = '${user.me_id}'
	          	for(tmp of res.list){
	          		str += createComment(tmp, me_id);
	          	}
	          	$('.comment-list').html(str);
	       }
	   });
	*/
	$(document).on('click', '.comment-pagination .page-item', function(){
		
		if($(this).hasClass('disabled')){
			return;
		}
		var page = $(this).data('page');
		//댓글 새로고침
		var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}';
		commentService.list(listUrl,listSuccess);
	});
	var page = 1;
	var listUrl = '/comment/list?page='+page+'&bd_num='+'${board.bd_num}';
	commentService.list(listUrl,listSuccess);
});


$('.likes-btn-box .btn').click(function(){
	var li_me_id = '${user.me_id}';
	var li_bd_num = '${board.bd_num}';
	var li_state = $(this).data('value');
	var likes = {
			li_me_id : li_me_id,
			li_bd_num: li_bd_num,
			li_state : li_state
	}
	$.ajax({
		async:false,
		type:'POST',
		data:JSON.stringify(likes),
		url: '<%=request.getContextPath()%>/board/likes',
		contentType:"application/json; charset=UTF-8",
		success : function(res){
			if(res == 2)
				alert('로그인 해주세요.')
	    	else if(res == 1)
	    		alert('추천했습니다.');
	    	else if(res == -1)
	    		alert('비추천했습니다.');
	    	else if(res == 0){
	    		if(li_state == 1)
		    		alert('추천을 취소했습니다.');
		    	else
		    		alert('비추천을 취소했습니다.');
	    	}
			loadLikes({
				li_bd_num : '${board.bd_num}'
			});
		}	
	});
});


function loadLikes(likes){
	$.ajax({
		async:false,
		type:'POST',
		data: JSON.stringify(likes),
		url: '<%=request.getContextPath()%>/board/likes/views',
		dataType:"json",
		contentType:"application/json; charset=UTF-8",
		success : function(res){
			$('.btn-up')
				.removeClass('btn-primary')
				.addClass('btn-outline-primary');
			$('.btn-down')
				.removeClass('btn-danger')
				.addClass('btn-outline-danger');
			if(res == -1){
				$('.btn-down')
				.removeClass('btn-outline-danger')
				.addClass('btn-danger');
			}else if(res == 1){
				$('.btn-up')
				.removeClass('btn-outline-primary')
				.addClass('btn-primary');
			}
			
		}
	});
}

function listSuccess(res){
	var str = '';
    var me_id = '${user.me_id}';
    if(res.list.length == 0){
    	$('.comment-list').html('');
    	$('.comment-pagination').html('');
    	return;
    }
    for(tmp of res.list){
    	str += createComment(tmp, me_id);
    }
    $('.comment-list').html(str);
    
    var paginationStr = createPagenation(res.pm);
    $('.comment-pagination').html(paginationStr);
}

function getDateToString(date){
	return "" + 
		date.getFullYear()  + "-" + 
		(date.getMonth()+1) + "-" +
		date.getDate()      + " " +
		date.getHours()     + ":" +
		date.getMinutes();
}
function insertSuccess(res){
	if(res){
   	alert('댓글 등록이 완료 되었습니다.');
   	$('.co_contents').val('');
   	var listUrl = '/comment/list?page=1&bd_num='+'${board.bd_num}';
		commentService.list(listUrl,listSuccess);
   	}else{
	   	alert('댓글 등록에 실패 했습니다.');
   	}
}


function createComment(comment, me_id){
	var co_reg_date = getDateToString(new Date(comment.co_reg_date));
	var str = '';
	str+=	'<div class="comment-box clearfix">'
	
	if(comment.co_ori_num != comment.co_num){
	str+=		'<div class="float-left" style="width:24px">└</div>'
	str+=		'<div class="float-left" style="width: calc(100% - 24px)">'
	}else{
	str+=		'<div class="float-left" style="width: 100%">'
	}
	str+=			'<div class="co_me_id">'+comment.co_me_id+'</div>'
	str+=			'<div class="co_contents">'+comment.co_contents+'</div>'
	str+=			'<div class="co_reg_date">'+co_reg_date+'</div>'
	if(comment.co_ori_num == comment.co_num)
	str+=			'<button class="btn btn-outline-success btn-rep-comment mr-2">답글</button>'
	if(comment.co_me_id == me_id){
	str+=			'<button class="btn btn-outline-dark btn-mod-comment mr-2" data-num="'+comment.co_num+'">수정</button>'
	str+=			'<button class="btn btn-outline-danger btn-del-comment" data-num="'+comment.co_num+'">삭제</button>'
	}
	str+=		'</div>'
	str+=		'<hr class="float-left" style="width:100%">'
	str+=	'</div>'
	return str;
}
function createPagenation(pm){
	var str = '';
	var prevDisabled = pm.prev ? '' : 'disabled';
	var nextDisabled = pm.next ? '' : 'disabled';
	var page = pm.criteria.page;
	
	str+=	'<ul class="pagination justify-content-center">'
	str+=    '<li class="page-item '+prevDisabled+'" data-page="'+(pm.startPage - 1)+'"><a class="page-link" href="javascript:;">이전</a></li>'
	for(i = pm.startPage; i<= pm.endPage; i++){
		var active = page == i ? 'active' : '';
	str+=    '<li class="page-item '+ active +'" data-page="'+i+'"><a class="page-link" href="javascript:;">'+i+'</a></li>'
	}
	str+=    '<li class="page-item '+nextDisabled+'" data-page="'+(pm.endPage + 1)+'"><a class="page-link" href="javascript:;">다음</a></li>'
	str+=  '</ul>'
	return str;
}
</script>
</body>
</html>
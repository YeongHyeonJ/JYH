<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<style>
.box-tabs{
	border:1px solid #dee2e6;
	border-color : transparent #dee2e6 #dee2e6 #dee2e6;
}

</style>
<body>
<div class="body container">
  <h2 class="mt-3">회원 정보 찾기</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs find-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" href="javascript:;" data-target=".id-box">아이디 찾기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="javascript:;" data-target=".pw-box">비밀번호 찾기</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="box-tabs">
    <div class="container id-box"><br>
      <h3>아이디 찾기</h3>
      <div class="form-group">
	  	<input type="text" class="form-control" name="me_email" placeholder="이메일을 입력하세요.">
	  </div>
	  <div class="form-group">
	  	<input type="text" class="form-control" name="me_name" placeholder="이름을 입력하세요.">
	  </div>
	  <button class="btn btn-outline-success col-12 btn-find-id mb-3">아이디 찾기</button>
    </div>
    
    <div class="container pw-box"><br>
      <h3>비밀번호 찾기</h3>
      <div class="form-group">
		<input type="text" class="form-control" name="me_email" placeholder="이메일을 입력하세요.">
	  </div>
	  <div class="form-group">
	  	<input type="text" class="form-control" name="me_id" placeholder="아이디를 입력하세요.">
	  </div>
	  <button class="btn btn-outline-success col-12 btn-find-pw mb-3">비밀번호 찾기</button>
    </div>
  </div>
</div>
<script>
$('.find-tabs .nav-link').click(function(){
	$('.find-tabs .nav-link').removeClass('active');
	$(this).addClass('active');
	var target = $(this).data('target');
	$('.box-tabs>div').hide();
	$(target).show();
});
$('.find-tabs .nav-link').eq(0).click();

$('.btn-find-id').click(function(){
	var me_email = $(this).parents('div').find('[name=me_email]').val();
	var me_name = $(this).parents('div').find('[name=me_name]').val();
	var member = {
			me_email : me_email,
			me_name : me_name
	}
	console.log(member);
	$.ajax({
		async:false,
		type:'POST',
		data: JSON.stringify(member),
		url: '<%=request.getContextPath()%>/member/find/id',
		contentType:"application/json; charset=UTF-8",
		success : function(res){
			if(res == ''){
				alert('일치하는 정보가 없습니다.');
			}else{
				alert('회원님의 아이디는 ' + res + ' 입니다.');
			}
		}
	});
});

$('.btn-find-pw').click(function(){
	var me_email = $('.pw-box [name=me_email]').val();
	var me_id = $('.pw-box [name=me_id]').val();
	var member = {
			me_email : me_email,
			me_id : me_id
	}
	console.log(member);
	$.ajax({
		async:false,
		type:'POST',
		data: JSON.stringify(member),
		url: '<%=request.getContextPath()%>/member/find/pw',
		contentType:"application/json; charset=UTF-8",
		success : function(res){
			console.log(res);
		}
	});
	
	
});


</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<!-- date picker -->
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<!-- 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/additional-methods.min.js"></script>
	<style>

	</style>
</head>
<body>
	<form class="container signup body" action="<%=request.getContextPath() %>/signup" method="post">
		<h1 class="title text-center">회원가입</h1>
		<div class="box" style="height: 100px; border: 1px solid black;">약관내용</div>
		<div class="form-group">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="form-check-input" name="agree">동의
				</label>
			</div>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="me_id" value="${user.me_id}">
		</div>
		<div class="form-group">
			<button id="idcheck" type="button" class="btn btn-outline-info form-control">아이디 중복 검사</button>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호" name="me_pw" id="me_pw" value="${user.me_pw}">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호확인" name="me_pw2">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="이름" name="me_name" value="${user.me_name}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="생년월일" name="me_birth" id="birth">
		</div>
		<div class="form-group">
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="me_gender" value="남성">남성
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="radio" class="form-check-input" name="me_gender" value="여성">여성
				</label>
			</div>
			<div>
				<label class="error" id="me_gender-error" for="me_gender"></label>
			</div>
		</div>
		<div class="form-group">
			<div class="form-inline mb-2">
				<input type="text" id="postcode" placeholder="우편번호" class="form-control col-6" name="me_address">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control col-6">
			</div>
			<input type="text" id="address" placeholder="주소" class="form-control mb-2">
			<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mb-2">
			<input type="hidden" name="me_address">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="전화번호(-를 포함하여 입력하세요.)" name="me_phone">
		</div>
	<button class="btn btn-outline-info form-control">회원가입</button>
	</form>
	<script>
	
	
	$('form').submit(function(){
		var isAgree = $('[name=agree]').is(':checked');
		//동의에 체크되지 않으면
		if(!isAgree){
			alert('동의에 체크해야합니다.');
			$('[name=agree]').focus();
			return false;
		}
		
		var address = $('#address').val() + ' ' +$('#detailAddress').val();
		$('[name=me_address]').val(address);
	});

	$('#birth').datepicker();
	$('#birth').datepicker('option','dateFormat', 'yy-mm-dd');

	
	//아이디 체크를 위한 참거짓
	var idCheck = false;
	//id=idcheck를 클릭했을때 
	$('#idcheck').click(function(){
		//클릭했을때 콘솔창에 1이 뜨는지 확인
		//console.log(1);
		var id = $('[name=me_id]').val();
		//name=me_id의 값을 가져와 id=값 선언 및 확인
		//console.log(id);
		$.ajax({
			async : false,
	        type :'get',
	        url : '<%=request.getContextPath()%>/idcheck?me_id='+id,
	        success : function(data){
	            console.log(data);
	            if(data == 'true'){
	            	alert('사용 가능한 아이디입니다.');
	            	idCheck = true;
	            }
	            else{
	            	alert('이미 가입된 아이디입니다.');
	            	idCheck = false;
	            }
	        }
	    });
	});
	
	$('[name=me_id]').change(function(){
		idCheck = false;
	});
	
	function execDaumPostcode() {
		new daum.Postcode({
			oncomplete: function(data) {
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if(data.userSelectedType === 'R'){
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
							extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if(data.buildingName !== '' && data.apartment === 'Y'){
							extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
				
				} 
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById("address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("detailAddress").focus();
			}
		}).open();
    }
	//체크
	$(function(){
	    $("form").validate({
	    	//유효성 검사를 체크하는 부분
	        rules: {
	        	//required 는 필수항목인지 체크하는 지정객체명
	        	//ex) 5~20글자의 영문소문자, 숫자, 특수문자 -,_ 사용가능
	            me_id: {
	                required : true,
	                minlength : 4,
	                regex : /^[A-Za-z0-9][A-z0-9_!~-]{4,19}$/
	            },
	            me_pw: {
	                required : true,
	                minlength : 4,
	                regex: /^[A-z0-9-_~!@#$%]{4,19}$/
	            },
	            me_pw2: {
	                equalTo : me_pw
	            },
	            me_name: {
	                required : true
	            },
	            me_gender: {
	            	required : true
	            },
	            me_birth: {
	                digits : true,
	                regex : /^\d{4}-\d{2}-\{2}$/
	            },
	            me_phone:{
	            	digits : true,
	            	regex : /^\d{3}-\d{4}-\{4}$/
	            }
	            
	        },
	        //규칙체크 실패시 출력될 메시지
	        messages : {
	            me_id: {
	                required : "필수로입력하세요",
	                minlength : "최소 4글자를 입력해주세요.",
	                regex : "5~20자의 영문 소문자 숫자와 특수기호 (_),(-)만 사용 가능합니다."
	            },
	            me_pw: {
	                required : "필수로입력하세요",
	                minlength : "최소 {4}글자이상이어야 합니다",
	                regex : "영문자, 숫자로 이루어져있으며 최소 하나이상 포함"
	            },
	            me_pw2: {
	                equalTo : "비밀번호가 일치하지 않습니다."
	            },
	            me_name: {
	                required : "필수로입력하세요"
	            },
	            me_gender: {
	            	required : "필수로입력하세요"
	            },
	            me_birth: {
	            	required : "필수로입력하세요",
	                regex : 'yyyy-mm-dd형태로 입력하세요.'
	            },
	            me_phone: {
	            	digits : "필수로입력하세요",
	            	regex : "xxx-xxxx-xxxx 형태로 입력하세요."
	            }
	            
	            
	        }
	    });
	})
	$.validator.addMethod(
	    "regex",
	    function(value, element, regexp) {
	        var re = new RegExp(regexp);
	        return this.optional(element) || re.test(value);
	    },
	    "Please check your input."
	);
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





<script>
	$(function(){
		/* {속성명 : 값, 속성명 : 값}
		*/
		$.ajax({
			//비동기(async)면 true 아니면 false
	        //비동기는 ajax가 끝나지 않아도 다음코드를 실행, 동기는 반대
			async : false,
	        type :'POST',
	        //서버로 보내는 data
	        data : {str : "sample"},
	        //데이터를 보낼 서버 url
	        url : "<%=request.getContextPath()%>/ajax/test1",
	        //<중요> dataType : 서버에서 보내준 데이터의 타입
	        //dataType : "json",
	        //contentType : 서버에 보낼 데이터(위의 data)
	        contentType :"application/json; charset=UTF-8",
	        //syccess : ajax를 이용하여 서버에 데이터 전송 후 서버에서 데이터를 처리한 후
	        //			성공했을 때 호출되는 함수
	        // -res : 서버에서 화면으로 보낸 데이터
	        success : function(res){
	            console.log(res);
	        }
	    });
		$.ajax({
			async : false,
	        type :'POST',
	        data : {str : "sample"},
	        url : "<%=request.getContextPath()%>/ajax/test2",
	        contentType :"application/json; charset=UTF-8",
	        success : function(res){
	            console.log(res);
	        }
	    });
		$.ajax({
			async : false,
	        type :'POST',
	        data : JSON.stringify({id : "qwe", pw : "asd"}),
	        url : "<%=request.getContextPath()%>/ajax/test3",
	        dataType : "json",
	        contentType :"application/json; charset=UTF-8",
	        success : function(res){
	            console.log(res);
	            console.log(res.address);
	            console.log(res=['address']);
	        }
	    });
	});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
fieldset {
	width: 220px;
}

table, th, tr, td {
	border-collapse: collapse;
	border: 1px solid black;
}

td {
	width: 130px;
}
</style>
<link rel="stylesheet" href="/StudentCourse/StudentCSS/css/joinForm.css">


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	$("#Id").keyup(function(){
	var idCheck = $("#Id").val();
	console.log(idCheck);
	$.ajax({
		type : "get",
		url : "checkId",
		data : {"uId" : idCheck},
		success:function(data){
		console.log("data:"+data);
		if(data=="OK"){
			$("#confirmId").css("color","green").text("사용가능한 아이디입니다")	
		}else{
			$("#confirmId").css("color","red").text("사용 불가능한 아이디입니다")
			}
		}
		})
	})
})
</script>

<script>
$(document).ready(function(){
	$("#checkPw").keyup(function(){
		
	var pw = $("#pw").val();
	var checkPw = $("#checkPw").val();
	
	$.ajax({
		type : "get",
		url : "checkPw",
		data : {"pw" : pw},
				
		success:function(data){
		if(pw == checkPw ){
			$("#confirmPw").css("color","green").text("비밀번호가 일치합니다")	
		}else{
			$("#confirmPw").css("color","red").text("비밀번호가 불일치합니다")
			}
		}
		})
	})
});
</script>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
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
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>




</head>

<body>
	<div class="container">
	
		<div class="row">
			<h5>회원가입을 진행해 주세요</h5>
			
			<form action="StudentJoin" method="post">
			
			<h2>등급</h2>
		<div class="input-group">
			<input type="radio" name="rank" value="학생" checked>
			 <label for="gender-male">학생</label>
			 <i class="fa fa-envelope"></i>
		</div>
		 
				<h2>아이디</h2>
				<div class="input-group input-group-icon">
				
				<input type="text" id="id" name="id" placeholder="아이디를 입력해주세요">
				
				<span id="confirmId"></span>
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>

				<h2>비밀번호</h2>
				<div class="input-group input-group-icon">
					<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요">
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>


				<h2>비밀번호 확인</h2>
				<div class="input-group input-group-icon">
					<input type="password" name ="checkPw" id="checkPw" placeholder="비밀번호를 확인해주세요">
					<span id="confirmPw"></span>
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
				<h2>이름</h2>
				<div class="input-group input-group-icon">
					<input type="text" id="name" name="name" placeholder="이름을 입력해주세요">
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
				</div>
		</div>
		<!--   <div class="col-half"> -->
		<h2>성별</h2>
		<div class="input-group">
			<input id="gender-male" type="radio" name="gender" value="male"
				checked /> <label for="gender-male">남</label> <input
				id="gender-female" type="radio" name="gender" value="female"> <label
				for="gender-female">여</label>
			<!--</div>  -->
		</div>
		<br>

		<h2>생년월일</h2>
		<div class="input-group input-group-icon">
			<input type="date" id="birth" name="birth" placeholder="생년월일을 입력해주세요">
			<div class="input-icon">
				<i class="fa fa-envelope"></i>
			</div>
		</div>

		<h2>전화번호</h2>
		<div class="input-group input-group-icon">
			<input type="text" id="ph" name="ph" placeholder="전화번호를 입력해주세요">
			<div class="input-icon">
				<i class="fa fa-envelope"></i>
			</div>
		</div>
		

		<h2>주소</h2>
<input type="text" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" name = "ad" placeholder="주소"><br>
<input type="text" id="sample6_detailAddress" placeholder="상세주소">
<input type="text" id="sample6_extraAddress" placeholder="참고항목">
		 	
		<!--  	
		<div id="layer"
			style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
				id="btnCloseLayer"
				style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
				onclick="closeDaumPostcode()" alt="닫기 버튼">
		</div>  -->
		
		<br>
		
		 <div class="row">
      <h4></h4>
      <div class="input-group">
        <input id="terms" type="checkbox">
        <label for="terms">위 내용을 확인하였습니다.</label>
      </div>
    </div>
    
    <div>
			<input type="submit" value="회원가입"
				onclick="location.href='finishLogin()'">
				</div>
				<br>

	        <input type="reset" value="다시하기">
		
		
		</div>
	</form>
	
</body>
<script>
function finishLogin() {
	var id = documnet.getElementById("id").value;
	if(id !=null) {
	prompt('회원가입이 완료되었습니다');
	location.href='/StudentCourse/Student/StudentJoin';	
}
}

</script>
</html>

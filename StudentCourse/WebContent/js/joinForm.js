$(document).ready(function () {
	$("#userId").keyup(function () {
		//아이디 길이 확인 메소드 호출 
		idCheck();
	});

	$("#userPw").keyup(function () {
		//비밀번호 길이 확인 메소드 호출
		pwCheck();
	});

	$("#confirmPw").keyup(function () {
		//비밀번호 재확인 메소드 호출
		confirmPassword();
	});
	$("#emailSel").change(function () {
		emailSelect();
	});
	$("#joinBtn").click(function () {
		memberJoin();
	});
});



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
//이벤트 호출

//회원가입 기능
function idCheck() {
	var id = $("#userId").val();
	console.log("id:" + id);
	console.log("idLength:" + id.length);
	if (id.length == 0) {
		$("#idResult").css("color", "red").text("아이디는 필수입니다.");
	} else if (id.length < 4 || id.length > 10) {
		$("#idResult").css("color", "red").text("아이디의 길이가 맞지 않습니다.");
	} else if (id.length >= 4 && id.length <= 10) {
		$("#idResult").css("color", "green").text("Good!!");
	}
}
function pwCheck() {
	var pw = $("#userPw").val();
	console.log("pw:" + pw);
	console.log("pwLength:" + pw.length);
	if (pw.length == 0) {
		$("#pwResult").css("color", "red").text("비밀번호는 필수입니다.");
	} else if (pw.length < 8 || pw.length > 16) {
		$("#pwResult").css("color", "red").text("비밀번호의 길이가 맞지 않습니다.");
	} else if (pw.length >= 8 && pw.length <= 16) {
		$("#pwResult").css("color", "green").text("Good!!");
	}
}
function confirmPassword(){
	var pw = $("#userPw").val();
	var cpw = $("#confirmPw").val();
	if(pw == cpw){
		$("#confirmResult").css("color","green").text("비밀번호 일치!");
	}else{
		$("#confirmResult").css("color","red").text("비밀번호가 일치하지 않습니다.");
	}
}

function emailSelect(){
	var email = $("#emailSel").val();
	console.log(email);
	$("#userEmail2").val(email);
}
function memberJoin(){
	var uId = $("#userId").val();
	var uName = $("#userName").val();
	var uBirth = $("#userBirth").val();
	var uEmail = $("#userEmail1").val() +"@"+$("#userEmail2").val()
	var msg = "[아이디] "+uId+"\n"+"[이름] "+uName+
			"\n[생년월일]"+uBirth+"\n"+"[이메일]"+uEmail;
	alert(msg);
}
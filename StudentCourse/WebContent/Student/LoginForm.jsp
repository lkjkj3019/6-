<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<link rel="stylesheet" href="../css/login_style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>로그인 페이지</title>
<style>
table,th,tr,td{
border:1px solid black;
border-collapse: collapse;

}
</style>
</head>
<body>
<form action="StudentLogin" method="post" id="login">
<br><br><br><br>
<br><br><br><br>
<fieldset>
            <legend>
                <h1>LOGIN</h1>
            </legend>
            <h3>아이디와 비밀번호를 입력하세요.</h3>
            <div class="login_form">
                <ul class="idpw">
                    <li><label>아이디</label><input type="text" name="id" id="id"></li>
                    <li><label>비밀번호</label><input type="password" name="pw" id="pw"></li>
                    <li><button onclick="Login()">로그인</button></li>
                </ul>
                <ul class=j>
                    <li>아이디가 없으신가요? <button type="button" onclick="Main()">메인으로</button></li>
                </ul>
            </div>
        </fieldset>
</form>
</body>
<script>
function Login(){
login.submit();
}
function join(){
	location.href="/StudentCourse/Student/Main.jsp"
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, th{
border : 1px solid white;
margin: 30px;
padding: 30px;
text-align: center;

}
h1, p, div{
text-align: center;
}
table{
margin-left: auto;
margin-right: auto;
width:70%;
}
.a{
background-color: #1d96b2;
color: #dedede;
font-size: bold;
}
.d{
background-color: #dedede;
}
.b{
background-color: white;
}
.title{
background-color: #1d96b2;
color: #dedede;
font-size: bold;
}
td{
border : 1px solid black;
}
body{
background-image:url(https://thumbs.dreamstime.com/b/autumn-thanksgiving-background-pumpkins-maple-leaves-turquoise-table-above-autumn-thanksgiving-background-pumpkins-160472384.jpg);
background-size: 2000px;
}
</style>
</head>

<body>
<h1>인천일보 아카데미 학생 강의 시간표</h1>
<h1>${loginResult }님의 시간표</h1>

<table>
<tr>
	<th class="title">교시</th>
	<th class="title">월</th>
	<th class="title">화</th>
	<th class="title">수</th>
	<th class="title">목</th>
	<th class="title">금</th>


	
</tr>
<tr>
	<th class="a">1<br>
(09:00~10:30)</th>	
	
	<td class="b">${dto2[0].sub2 }<br>
	${dto2[0].classroom2 }<br>
	${dto2[0].teacher2 }</td>
		
	<td class="b">${dto2[1].sub2 }<br>
	${dto2[1].classroom2 }<br>
	${dto2[1].teacher2 }</td>
		
	<td class="b">${dto2[2].sub2 }<br>
	${dto2[2].classroom2 }<br>
	${dto2[2].teacher2 }</td>
		
	<td class="b"></td>
	<td class="b"></td>
	
</tr>

	
<tr>
	<th class="a">2<br>
(10:30~12:00)</th>
	
	<td class="b">${dto2[0].sub2 }<br>
	${dto2[0].classroom2 }<br>
	${dto2[0].teacher2 }</td>
	
	<td class="b">${dto2[1].sub2 }<br>
	${dto2[1].classroom2 }<br>
	${dto2[1].teacher2 }</td>
		
	<td class="b">${dto2[2].sub2 }<br>
	${dto2[2].classroom2 }<br>
	${dto2[2].teacher2 }</td>	
	
	<td class="b"></td>
	<td class="b"></td>
</tr>
<tr>
	<th class="a">점심 시간<br>
(12:00~13:00)</th>
	<td colspan="5" class="d">점심</td>
</tr>
<tr>
	<th class="a">3<br>
(13:00~14:30)</th>
	
   
	<td class="b">${dto2[0].sub2 }<br>
	${dto2[0].classroom2 }<br>
	${dto2[0].teacher2 }</td>
	
	<td class="b">${dto2[1].sub2 }<br>
	${dto2[1].classroom2 }<br>
	${dto2[1].teacher2 }</td>
		
	<td class="b">${dto2[2].sub2 }<br>
	${dto2[2].classroom2 }<br>
	${dto2[2].teacher2 }</td>	
	
	<td class="b"></td>
	<td class="b"></td>
</tr>
<tr>
	<th class="a">4<br>
(14:30~16:00)</th>
	
	<td class="b">${dto2[0].sub2 }<br>
	${dto2[0].classroom2 }<br>
	${dto2[0].teacher2 }</td>
	
	<td class="b">${dto2[1].sub2 }<br>
	${dto2[1].classroom2 }<br>
	${dto2[1].teacher2 }</td>	
	
	<td class="b">${dto2[2].sub2 }<br>
	${dto2[2].classroom2 }<br>
	${dto2[2].teacher2 }</td>	
	
<td class="b"></td>
	<td class="b"></td>
</tr>

</table>
<div>
	<button onclick="location.href='/StudentCourse/Course/CourseList'">추가신청</button>
	<button onclick="location.href='/StudentCourse/Student/Main2.jsp'">메인페이지</button>
	<button onclick="location.href='/StudentCourse/Student/StudentLogout'">로그아웃</button>
	<button onclick="ForgiveSub()">수강포기</button>
	</div>
<script>
function ForgiveSub() {
	var forgibeSub = prompt("포기할 과목을 입력하세요")
	var subname = '${dto2[0].sub2 }';
	var subname1 = '${dto2[1].sub2 }';
	var subname2 = '${dto2[2].sub2 }';
	
	if (subname == forgibeSub){
		
	location.href="/StudentCourse/Student/ForgiveSub?pnumber2=${dto2[0].pnumber2}"
	
	} else if ( subname1 == forgibeSub){
	location.href="/StudentCourse/Student/ForgiveSub?pnumber2=${dto2[1].pnumber2}"
		
	} else if ( subname2 == forgibeSub){
		
	location.href="/StudentCourse/Student/ForgiveSub?pnumber2=${dto2[2].pnumber2}"
	} else {
		alert('등록된 과목이 없습니다.')
	}
}
</script>
</body>
</html>
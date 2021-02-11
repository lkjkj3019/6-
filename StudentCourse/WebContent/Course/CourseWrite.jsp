<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table, tr, td{
   border : 2px solid #f4623a;
   border-collapse: collapse;
   margin: 5px;
   padding: 5px;
   height:100px;
}
.a,h1{
text-align:center;
}
select{
margin: 10px;
   padding: 10px;
}
table{
margin-left: auto;
margin-right: auto;
width:70%;
}
</style>
</head>
<body>
<h1>교수진 입력 페이지</h1>
<form action="/StudentCourse/Course/CourseWrite" method="post" name="CourseWriteForm" enctype="multipart/form-data">
<table>
 <tr>
      <td class="a">지도교수</td>
      <td>
      <select name="teacher">
    <option value="">교수 선택</option>
    <option value="양기두">양기두</option>
    <option value="임훈">임훈</option>
    <option value="차지헌">차지헌</option>
</select>
</td>
   </tr>
   <tr>
      <td class="a">첨부파일</td>
      <td><input type="file" name="pfile"></td>
   </tr>
   <tr>
      <td class="a">수강신청 과목</td>
         <td>
      <select name="sub">
    <option value="">과목 선택</option>
    <option value="자바">자바</option>
    <option value="오라클">오라클</option>
    <option value="C언어">C언어</option>
</select>
</td>
   </tr>
   <tr>
      <td class="a">수업시간</td>
            <td>
      <select name="time">
    <option value="">시간 선택</option>
    <option value="월요일  08:30~20:00">월요일  08:30~20:00</option>
    <option value="화요일  08:30~20:00">화요일  08:30~20:00</option>
    <option value="수요일  08:30~20:00">수요일  08:30~20:00</option>
</select>
</td>
   </tr>
   <tr>
      <td class="a">강의실</td>
         <td>
      <select name="classroom">
    <option value="">강의실 선택</option>
    <option value="5층 B반">5층 B반</option>
    <option value="4층 D반">4층 D반</option>
    <option value="4층 A반">4층 A반</option>
</select>
</td>
   </tr>
<tr>
		<td colspan="2">
		<input type="submit" value="등록">
		<input type="button" value="목록" onclick="location.href='/StudentCourse/Course/CourseList'"></td>
		
	</tr>
</table>
</form>
</body>
</html>
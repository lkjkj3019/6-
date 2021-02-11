<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/StudentCourse/CourseCSS/css/CourseList.css">
<style>
table, tr, td, th{
border : 1px solid black;
border-collapse: collapse;
margin: 5px;
padding: 5px;
text-align: center;
}
h1, p, div{
text-align: center;
}
table{
margin-left: auto;
margin-right: auto;
}
</style>
</head>
<body>
<div class="container">
  <table class="responsive-table">
    <caption>수강신청목록</caption>
    <thead>

 	<tr>
 		 	
 		<th scope="col" >number</th> 		
 		<th scope="col" >picture</th> 		
 		<th scope="col" >Professor</th>
 		<th scope="col" >Subject</th> 		
 		<th scope="col">Time</th> 		
 		<th scope="col" >ClassRoom</th>
 		<th scope="col" >application</th>
 	</tr>
 	    </thead>
 	     <tfoot>
      <tr>
        <td colspan="7">Sources: <a href="http://en.wikipedia.org/wiki/List_of_highest-grossing_animated_films" rel="external">IncheonIlBo</a> &amp; <a href="http://www.boxofficemojo.com/genres/chart/?id=animation.htm" rel="external">KJS PHH LKJ JSD</a>. Data is current as of November 23, 2020.</td>
      </tr>
    </tfoot>
    <tbody>
 	    
 	    
 <c:forEach var="courselist" items="${courselist}">
 
 	<tr>
 		  <td scope="row">${courselist.pnumber}</td>
 		<td data-title="Released" ><img src="/StudentCourse/FileUpload/${courselist.pfile }" width="70"></td>
 		<td data-title="Studio" >${courselist.teacher }</td>
 		<td  data-title="Worldwide Gross" data-type="currency" >${courselist.sub }</td>
 		<td data-title="Domestic Gross" data-type="currency" >${courselist.time }</td>
 		<td data-title="Foreign Gross" data-type="currency" >${courselist.classroom }</td>
 		<td data-title="Budget" data-type="currency" ><c:if test = "${loginResult != 'admin' }"><a href="/StudentCourse/Student/SCHEDULE?pnumber=${courselist.pnumber }">신청</a></c:if></td>
 		
 	</tr>
 	
 </c:forEach>
     </tbody>
 </table>
 </div>
 <div>
<c:if test = "${loginResult == 'admin' }"><button onclick="location.href='CourseWrite.jsp'">교수진 추가입력</button></c:if>
<c:if test = "${loginResult != 'admin' }">
<input type="submit" onclick="location.href='/StudentCourse/Student/new'" value="시간표">
<button onclick="location.href='/StudentCourse/Student/Main2.jsp'">메인페이지로</button></c:if>
<button onclick="location.href='/StudentCourse/Student/StudentLogout'">로그아웃</button>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
<style type="text/css">
 
 table{
 border: 1px solid;
 border-collapse: collapse;
 margin-left: 10px;
 }
 
 #memberListForm{
 width:650px;
 text-align: center
 }
 
 #selectCategory{
   height: 30px;
   margin-left: 10px;
 }
 #searchIdButton{height: 30px;}
 #searchId {height: 30px;}
 
 th{background-color:silver;}
 
 td,th {
 padding: 10px;
 border: 1px solid;
 }
</style>

</head>


<body>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">전체강의실조회</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">우리반교육생조회</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">자리배치이력조회</a>
    </li>
    <li class="nav-item">
      <a class="nav-link " href="#">자리배치하기(반장일때만)</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link " href="myPage.html">홈으로</a>
    </li>
    
    
  </ul>
</nav>


<hr>
 <br>
 <select id="selectCategory">
  <option value="이름">이름</option>
  <option value="부서">부서</option>
  <option value="사번">사번</option>
  <option value="이메일">이메일</option>
 </select>  
 
 <input id="searchId" placeholder="김성은"> 
 <button id="searchIdButton">조회</button>

<hr>
  <div id="memberListForm">
	<table id="memberList">
	<tr>
	 <th>사번</th>
	 <th>이름</th>
	 <th>부서</th>
	 <th>직위</th>
	 <th>전화번호</th>
	 <th>이메일</th>
	</tr>
	
	<tr>
	  <td>148456</td>
	  <td>김성은</td>
	  <td>경영지원팀</td>
	  <td>사원</td>
	  <td>010-1234-5670</td>
	  <td>kimsg1@naver.com</td>
	</tr>
	
	<tr>
	  <td>124556</td>
	  <td>김성은</td>
	  <td>연구개발팀</td>
	  <td>사원</td>
	  <td>010-3552-4937</td>
	  <td>kims2@gmail.com</td>
	</tr>
	
	<tr>
	  <td>123569</td>
	  <td>김성은</td>
	  <td>ICT융합연구소</td>
	  <td>대리</td>
	  <td>010-3262-4833</td>
	  <td>sgkim23@daum.net</td>
	</tr>
	
	<tr>
	  <td>123479</td>
	  <td>김성은</td>
	  <td>신사업개발팀</td>
	  <td>대리</td>
	  <td>010-2595-4867</td>
	  <td>kim3@naver.com</td>
	</tr>
	
	<tr>
	  <td>123445</td>
	  <td>김성은</td>
	  <td>항공시스템팀</td>
	  <td>과장</td>
	  <td>010-8734-4652</td>
	  <td>sung2@gmail.com</td>
	</tr>
	
	<tr>
	  <td>164396</td>
	  <td>김성은</td>
	  <td>그룹웨어서비스팀</td>
	  <td>차장</td>
	  <td>010-9545-4679</td>
	  <td>tjdt11@gmail.com</td>
	</tr>
	
	<tr>
	  <td>463856</td>
	  <td>김성은</td>
	  <td>금융결제팀</td>
	  <td>사원</td>
	  <td>010-8569-4752</td>
	  <td>rlar11@daum.net</td>
	</tr>
	</table>
	<br>
	
    <a href="#"><i class="fa fa-angle-left"></i></a>
	<span name="nowpage">1/</span>
	<a href="#">2 </a>
	 <a href="#"><i class="fa fa-angle-right"></i></a>
  </div>

</body>
</html>
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
   #header {
     margin-bottom: 10px;
   }
  </style>


<style type="text/css">
	table {
		width: 60%;
		heigth: 100px;
		margin: auto;
		text-align: center;
	}
	th, td {
		text-align: center;
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="header">

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

	<div>
		<div>
			<input type="date" value="2022-02-18">
			~ <input type="date" >
			<input type="button" value="자리배치 하기">
		</div>
		<div>
			강의실: <input type="text" readonly="readonly" value="2501호">
		</div>
	</div>
	<hr width="100%" color="black">
	<div>
		<table border="1">
			<tr><th colspan="8">칠판</th></tr>
			<tr><td>유영균</td>
				<td>김은혜</td>
				<td>정태연</td>
				<td>이유림</td>
				<td>배수민</td>
				<td>엄상인</td>
				<td>최다연</td>
				<td>X</td></tr>
			<tr><td>김성은</td>
				<td>박기웅</td>
				<td>오재욱</td>
				<td>이현정</td>
				<td>노경환</td>
				<td>김문정</td>
				<td>권유진</td>
				<td>오동근</td></tr>
			<tr><td>이창희</td>
				<td>박혜진</td>
				<td>임한솔</td>
				<td>채수빈</td>
				<td>박동은</td>
				<td>윤태완</td>
				<td>김정현</td>
				<td>이항영</td></tr>
		</table>
	</div>
	<hr width="100%" color="black">
	<div align="right">
		<input type="button" value="자리확정하기">
	</div>
</body>
</html>
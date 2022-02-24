<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
<title>강의실 조회</title>
<style type="text/css">
  #search {
    margin-top: 10px;
  }
</style>
</head>

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


	<div id="search">
		강의실 검색 : <select name="rooms">
					<option value=" " selected> -- 선택 --</option>
					<option value="2501" selected>2501호</option>
					<option value="2503 " selected>2503호</option>
					<option value="2505 " selected>2505호</option>
				  </select>
		<button>조회</button> <br>
		
		 <button onclick="history.back()">뒤로가기</button>
	</div>
	<hr style='border:solid 2px black'>

	
	<!-- first div ------------------------------------  -->
	
	<div style = "float:left; margin-right:100px;">
	<h2>강의실 구조</h2>
	
	<div>
		<h2> <2503호> </h2>
		<img src="C:\Users\USER\Desktop\2503.jpg">
	</div>
	
	<!-- 여기 아니면 그냐 이미지파일로 대체해도 상관없음 -->
	
	

	<table border="1">
		<th>1분단</th>
		<th>2분단</th>
		<th>3분단</th>
		<th>4분단</th>
		
		<tr>
		    <td>a1,a2</td>
		    <td>a2</td>
		    <td>a3</td>
		    <td>a4</td>
		</tr>
		
		<tr>
		    <td>b1</td>
		    <td>b2</td>
		    <td>b3</td>
		    <td>b4</td>
		</tr>
		
		
		<tr>
		    <td>c1</td>
		    <td>c2</td>
		    <td>c3</td>
		    <td>c4</td>
		</tr>
		
			
		<tr>
		    <td>d1</td>
		    <td>d2</td>
		    <td>d3</td>
		    <td>d4</td>
		</tr>
		
		
	 	
    </table> 
    			
    <div>수용인원 :32명</div>
    
    </div>
    
    
    <!-- first div end ------------------------------------  -->
	
    
    <!-- second div start ------------------------------------  -->
    <div style="float:left; width:200px; height:400px; border:1px solid black">
    <h1>비품 현황</h1> 
    <table border="1" id="2503_fixtures">
		<th>목록</th>
		<th>개수</th>
		
		<tr>
		    <td>노트북</td>
		    <td>24</td>
		</tr>
		
		<tr>
		    <td>캐비넷</td>
		    <td>20</td>
		   
		</tr>
		
		
		<tr>
		    <td>모니터</td>
		    <td>24</td>
		    
		</tr>
		
			
		<tr>
		    <td>키보드</td>
		    <td>24</td>
		   
		</tr>
		
		<tr>
		    <td>의자</td>
		    <td>32</td>
		   
		</tr>
		
		<tr>
		    <td>책상</td>
		    <td>16</td>
		   
		</tr>
		
    </div>
     <!-- second div end ------------------------------------  -->
    
   
    
    
</html>
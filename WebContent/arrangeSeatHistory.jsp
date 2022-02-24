<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자리배치 이력 조회</title>

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
<script type="text/javascript">
  if(${dateError}) alert("날짜에 해당하는 배치이력이 존재하지 않습니다.");
</script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link " href="controller?cmd=myPageUI">홈</a></li>
		<li class="nav-item"><a class="nav-link" href="controller?cmd=searchMemberUI">우리반교육생조회</a></li>
		<li class="nav-item active"><a class="nav-link" href="controller?cmd=arrangeSeatHistoryUI">자리배치이력조회</a></li>
		<c:if test="${memberVO.isLeader == true}">
			<li class="nav-item"><a class="nav-link " href="controller?cmd=arrangeSeatUI">자리배치하기</a></li>
		</c:if>
		<li class="nav-item"><a class="nav-link" href="controller?cmd=roomInfoAction">전체강의실조회</a></li>
	</ul>
	<a class="btn btn-outline-light" href="controller?cmd=logoutAction" role="button" style="margin-left:auto;">로그아웃</a>
	</nav>

	<div>
	  <form action="controller?cmd=arrangedRoomSearch" method="post">
		<div>
			<input type="date" name="date" >
			<input type="submit" value="강의실조회">
		</div>
	 </form>
		<div>
			강의실: <input type="text" readonly="readonly" value="${roomVO.location}">
		</div>
	</div>
	<hr width="100%" color="black">
	<div>
	   ${date} &nbsp; 자리배치
	</div>
	<div align="right">
		<input type="button" value="강의실 정보 상세 조회"><br>
		* 실제 책상 배치는 강의실 정보에서 확인
	</div>
	<div>
		<table border="1">
		
		   <tr><th colspan="${roomVO.colCount}">칠판</th></tr>
		   <c:forEach var="i" begin="1" end="${roomVO.rowCount}">
		       <tr>
		       <c:forEach var="j" begin="1" end="${roomVO.colCount}">
		           <td>빈자리</td>
		       </c:forEach>
		       </tr>
		   </c:forEach> 
		   
		</table>
		<script type="text/javascript">
		    var rows = document.getElementsByTagName("tr");
		     //console.log(rows.length+"row");
		    <c:forEach items="${seatHistoryList}" var="item">
		      console.log("${item.rowNumber}"  + "${item.colNumber}")
		      var row = parseInt("${item.rowNumber}")+1;
		      var col = parseInt("${item.colNumber}");
		    
		      var cells = rows[row];
		      var cells2 = cells.getElementsByTagName("td")[col].firstChild;
		      cells2.data = "${item.memberName}(${item.memberId})";
		     </c:forEach>
		</script>
	</div>
	<hr width="100%" color="black">
</body>
</html>
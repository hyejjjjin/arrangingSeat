<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link " href="controller?cmd=myPageUI">홈</a></li>
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
		<div>
			<input type="date" value="2022-02-18">
			<input type="button" value="이력조회">
		</div>
		<div>
			강의실: <input type="text" readonly="readonly" value="2501호">
		</div>
	</div>
	<hr width="100%" color="black">
	<div>
		배치 이력이 존재하지 않습니다.<br>
		강의 기간이 아닙니다.
	</div>
	<hr width="100%" color="black">
</body>
</html>
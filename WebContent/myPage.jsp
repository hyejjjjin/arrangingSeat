<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" type="text/css" href="myPage.css">
</head>



<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link " href="controller?cmd=myPageAction">홈</a></li>
		<li class="nav-item"><a class="nav-link" href="controller?cmd=searchMemberUI">우리반교육생조회</a></li>
		<li class="nav-item "><a class="nav-link" href="controller?cmd=arrangeSeatHistoryUI">자리배치이력조회</a></li>
		<c:if test="${memberVO.isLeader == true}">
			<li class="nav-item"><a class="nav-link " href="controller?cmd=arrangeSeatUI">자리배치하기</a></li>
		</c:if>
		<li class="nav-item"><a class="nav-link" href="controller?cmd=roomInfoAction">전체강의실조회</a></li>
	</ul>
	<form action="controller?cmd=logoutAction" method="post">
	<input type="submit" value="강력 로그아웃">
	</form>
	<a class="btn btn-outline-light" href="controller?cmd=logoutAction" role="button" style="margin-left:auto;">로그아웃</a>
	</nav>

	<div id="myInfoLayout" style="background-color: lightgray; width: 1000px; border-radius: 50px; padding: 50px; margin: auto; margin-top:20px;">
		<img alt="프로필 사진" src="images/default-user-image.png" class="rounded mx-auto d-block" style="width:200px; height:200px; margin-bottom:20px;">
		<div>
			<div>
				${memberVO.name}
				<span class="badge badge-primary text-wrap" style="width: 10rem; background-color:#89BFFF;">${memberVO.educationName}(${memberVO.roomLocation})</span>
				<c:if test="${isLeader == true}">
					<span class="badge badge-primary text-wrap" style="width: 6rem; background-color:#FF8989;">반장</span>
				</c:if>
			</div>
			<div>${memberVO.birthday}</div>
			<div>${memberVO.phoneNumber}</div>
			<div>${memberVO.email}</div>
		</div>
	</div>
</body>
</html>
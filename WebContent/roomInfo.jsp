<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>강의실 조회</title>
<style type="text/css">
#search {
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link " href="controller?cmd=myPageAction">홈</a></li>
		<li class="nav-item"><a class="nav-link" href="controller?cmd=searchMemberUI">우리반교육생조회</a></li>
		<li class="nav-item "><a class="nav-link" href="controller?cmd=arrangeSeatHistoryUI">자리배치이력조회</a></li>
		<c:if test="${isLeader == true}">
			<li class="nav-item"><a class="nav-link " href="controller?cmd=arrangeSeatUI">자리배치하기</a></li>
		</c:if>
		<li class="nav-item active"><a class="nav-link" href="controller?cmd=roomInfoAction">전체강의실조회</a></li>
	</ul>
	<a class="btn btn-outline-light" href="controller?cmd=logoutAction" role="button" style="margin-left:auto;">로그아웃</a>
	</nav>
	<c:if test="${roomList != null}">
		강의실 검색 : <select name="roomNumber" required>
			<option value="" disabled selected>-- 선택 --</option>
			<c:forEach var="room" items="${roomList}">
				<option value=${room.roomNumber}>${room.location}</option>
			</c:forEach>
		</select>
		<input class="btn btn-primary" type="button" value="조회" onclick="requestRoomInfo()">
		<hr style='border: solid 2px black'>
	</c:if>
	<div>
		강의실을 선택하세요
	</div>
	
	<script type="text/javascript">
	var xhr = null;
	function getXMLHttpRequest(){
		if(window.ActiveXObject){
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e1){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					return null;
				}
			}
		} else if (window.XMLHttpRequest){
			return new XMLHttpRequest();
		} else {
			return null;
		}
	} //XMLHttpRequest 객체 생성
	
	function requestRoomInfo(URL) {
		console.log("여긴 잘 타나?");
		roomNumber = document.querySelector('select').value;
		URL = "controller?cmd=searchRoomAction";// encodeURIComponent(param); //URL에 전송한 데이터 추가
		xhr = getXMLHttpRequest(); //객체 얻기
		xhr.onreadystatechange = responseRoomInfo; //서버에서 응답 준비가 되면 호출할 함수(콜백함수) 등록
		xhr.open("POST", URL, true); //연결
		xhr.send("roomNumber="+roomNumber); //전송
	} //서버에 요청
	
	function responseRoomInfo(){
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				var str = xhr.responseText; //서버에서 보낸 내용 받기
				//document.querySelectorAll('tr')[1].querySelectorAll('td')[1]= str; //요소 콘텐츠 변경
				
				console.log(typeof str);
				console.log(str);
			} else {
				alert("Fail : "+ xhr.status);
			}
		}
	} //응답
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디/비밀번호 찾기</title>
</head>
<body>
	<div id="findIdLayout">
		<h1>ID 찾기</h1>
		<div>아래 중 하나를 입력하여 ID를 찾으세요.</div>
		<div><input type="radio" name="findIdInfo">사번<input id="memberId"></div>
		<div><input type="radio" name="findIdInfo">이메일<input id="email" type="email"></div>
		<div><input type="radio" name="findIdInfo">전화번호<input id="phoneNumber" type="tel"></div>
		<button>찾기</button>
	</div>
	<div id="findPwLayout">
		<h1>PW 찾기</h1>
		<div>ID<input id="loginId"></div>
		<div>사번<input id="memberId"></div>
		<button>찾기</button>
	</div>
</body>
</html>
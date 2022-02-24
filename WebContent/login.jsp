<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="controller?cmd=loginAction" method="post">
	<div id="idPwInputLayout">
		<div name="id">ID<input name="id"></div>
		<div name="pw">PW<input type="password" name="pw"></div>
	</div>
	<div id="buttonsLayout">
		<input type="submit" value="로그인">
		<button>ID/PW 찾기</button>
	</div>
	</form>
</body>
</html>
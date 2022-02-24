<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보 수정</title>
</head>
<body>
	<div id="modifyPw">
		<div id="pwInput">비밀번호<input type="password"></div>
		<div id="newPwInput">새 비밀번호<input type="password"></div>
		<div id="newPwCheck">새 비밀번호 확인<input type="password"></div>
		<button>비밀번호 변경</button>
	</div>
	<div id="modifyMyInfo">
		<div id="attachPicture">
			<input id="picture" type="file">
		</div>
		<div id="name">이름<input readonly="readonly" value="홍길동"></div>
		<div id="birthday">생일<input type="date" value="1999-11-30"></div>
		<div id="phone">전화번호<input type="tel" value="010-1234-5678"></div>
		<div id="email">이메일<input type="email" value="honggildong@gmail.com"></div>
		<button>저장</button>
	</div>
</body>
</html>
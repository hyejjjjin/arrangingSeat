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
	</head>
	<body>
<!-- first div ------------------------------------  -->
	<div style="float: left; margin-right: 100px;">
		<h2>강의실 구조</h2>
		<div>
			<h2><${roomVO.location}></h2>
		</div>
		<table border="1">
			<c:forEach var="i" begin="1" end="${roomVO.rowCount}">
				<tr>
					<c:forEach var="j" begin="1" end="${roomVO.colCount}">
					<td style="width:50px; height:20px;"></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<div>수용인원 : ${roomVO.capacity}명</div>
	</div>
	<!-- first div end ------------------------------------  -->
	<!-- second div start ------------------------------------  -->
	<div style="float: left; width: 200px; height: 400px; border: 1px solid black">
		<h1>비품 현황</h1>
		<table border="1" id="2503_fixtures">
			<th>목록</th>
			<th>개수</th>
			<tr>
				<td>노트북</td>
				<td>${roomVO.labtop}</td>
			</tr>
			<tr>
				<td>캐비넷</td>
				<td>${roomVO.cabinet}</td>
			</tr>
			<tr>
				<td>모니터</td>
				<td>${roomVO.monitor}</td>
			</tr>
			<tr>
				<td>키보드</td>
				<td>${roomVO.keyboard}</td>
			</tr>
			<tr>
				<td>의자</td>
				<td>${roomVO.chair}</td>
			</tr>
			<tr>
				<td>책상</td>
				<td>${roomVO.desk}</td>
			</tr>
		</table>
	</div>
	<!-- second div end ------------------------------------  -->
	</body>
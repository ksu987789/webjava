<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>푸터</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.footer{
			width:100%;
			background-color:#eaf7fe;
		}
		#flogo{
			padding-top:20px;
			margin:auto;
		}
		#aa{
			text-align:left;
		}
	</style>
</head>
<body>

	<div class = "footer" >
	<div class="row">
		<div id ="flogo" class="col-md-4" align="right">
			<a href="#">
				<img src="${contextPath }/resources/image/logo1.png">
			</a>
		</div>
		<div class="col-md-4" align="center">
			<br>
			<p>상호명 : 7조</p>
			<p>사업자등록번호 : 0000</p>
			<p>주소 : 대전 광역시</p>
			<p>이메일 : aaaa@naver.com</p>
			<p>연락처 : 042)000-0000</p>
		</div>
		<div id="aa" class="col-md-4">
			<br>
			<p><strong>고객센터</strong></p> 
			<p>전화번호 : 000-0000</p>
			<p>주소 : 대전 광역시 서구 둔산동</p>
			<p>FAX : 042-000-0000 / E-Mail : aaaa@naver.com</p>
			<a href="#"><strong>고객센터 바로가기</strong></a>
		</div>
		</div>
	</div>

</body>
</html>
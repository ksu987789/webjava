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
	<title>헤더</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	 <style>
		.header{
			
			background-color:#eaf7fe;
		}
		
		#gnb{
			width:100%
		}

		#search2{
			padding:2em;
			margin:auto;
			text-align:center;
		}
		.row{
			
			margin:auto;
			width:100%;
		}
		#mainlogo{
			padding:1em;
			margin:auto;
			text-align:center;
		}

		#nav1{
			
			background-color:#a8daf9;
			
		}

		#n1{
			justify-content: center;
		}
		strong{
			color:#41627D;
		}
	</style>

</head>
<body>
<div class="header">
	<div class="row">
		<div id="mainlogo" class="col-md-9">
			<a href="${contextPath }/main.do" >
				<img src="${contextPath }/resources/image/mainlogo.png"></a>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4" id="search2">
  			  <div class="input-group">
  			    <input type="text" class="form-control" placeholder="내용을 입력하세요">
    			  <span class="input-group-btn">
       				 <button class="btn btn-default" type="button">검색</button>
    			  </span>
 			   </div><!-- /input-group -->
 		 </div>
	</div>

</div>
	<nav id="nav1" class = "navbar-expand navbar-dark">
		
		<ul id="n1" class = "navbar-nav ">
			<li class = "btn btn-lg btn-default"><a class = "nav-link" href="${contextPath }/board/osSoccer.do"><strong>해외축구</strong></a></li>
			<li class = "btn btn-lg btn-default"><a class = "nav-link" href="#"><strong>국내축구</strong></a></li>
			<li class = "btn btn-lg btn-default"><a class = "nav-link" href="#"><strong>뉴스</strong></a></li>
			<li class = "btn btn-lg btn-default"><a class = "nav-link" href="#"><strong>자유</strong></a></li>
			<li class = "btn btn-lg btn-default"><a class = "nav-link" href="#"><strong>축구몰</strong></a></li>
	
		</ul>
	</nav>	
</body>
</html>
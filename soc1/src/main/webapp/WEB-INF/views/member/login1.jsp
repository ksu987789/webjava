<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>


<!DOCTYPE html>
<html>
<head>
<title>login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
      .container{
      	padding-top:50px;
      	padding-bottom:50px;
      }
    </style>
    <script type="text/javascript">
    	function moveSign(){
    		location.href="${contextPath}/member/joinForm.do";
    	}
    	
    	
    </script>
</head>
<body class="text-center">
<div class="container">
<h3>로그인</h3>
  <hr/>
<main class="form-signin">
  <form>
  <center>
    
    <div class="col-md-4 col-md-offset-3" >
      <input type="id" class="form-control" id="floatingId" placeholder="아이디">
    </div>
    <p></p>
    <br>
    <div class="col-md-4 col-md-offset-3">
      <input type="password" class="form-control" id="floatingPassword" placeholder="비밀번호">
    </div>
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> 아이디 저장하기
      </label>
      <a href="#" id="idFind">ID/PW 찾기</a>
    </div>
    <button class="btn btn-primary" type="submit">로그인</button><br><br>
    <button class="btn btn-primary" onClick="moveSign()">회원가입</button>
  <center>  
  </form>
</main>
</div>
</body>
</html>

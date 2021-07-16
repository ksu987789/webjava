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
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
      
		.container{
			padding:2em;
		}
		h3{text-align:center;}
	
		#aa1{
			margin:0;
			padding-left:455px;
		}

		
    </style>
    <script type="text/javascript">
    /*유효성 검사*/
    function Validation(){
    	var RegExp = /^[a-zA-Z0-9]{4,12}$/;
    	var objId = document.getElementById("id");
        var objPwd = document.getElementById("floatingPassword"); //비밀번호
        var objPwd2 = document.getElementById("floatingRePassword"); //비밀번호확인
        var objEmail = document.getElementById("email");//메일
        var objNum = document.getElementById("phoneNumber"); //주민번호
        var objAddress = document.getElementById("address"); //주소

    	if(objId.value==""){
             alert("ID를 입력해주세요.");
             return false;
        }
        if(!RegExp.test(objId.value)){ //아이디 유효성검사
             alert("ID는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
             return false;
        }
        
        if(objPwd.value==""){
            alert("비밀번호를 입력해주세요.");
            return false;
       	}
        if(!RegExp.test(objPwd.value)){ //패스워드 유효성검사
            alert("Password는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");
            return false;
        }
        if(objPwd2.value==""){
            alert("비밀번호 확인을 입력해주세요.");
            return false;
       	}
        
        if(objPwd2.value!=objPwd.value){ //비밀번호와 비밀번호확인이 동일한지 검사
            alert("비밀번호가 서로 틀립니다. 다시 확인하여 입력해주세요.");
            return false;
        }

        if(objEmail.value==""){
            alert("이메일을 입력해주세요.");
            return false;
       	}
        
        if(objNum.value==""){
            alert("휴대전화번호를 입력해주세요.");
            return false;
       	}
        
        if(objAddress.value==""){
        	alert("주소를 입력해주세요.");
        	return false;
        }

    }
    
    
    
    /* 체크 박스  */
    function checkSelectAll()  {
    	  // 전체 체크박스
    const checkboxes  = document.querySelectorAll('input[name="selectone"]');
    	  // 선택된 체크박스
    const checked = document.querySelectorAll('input[name="selectone"]:checked');
    	  // select all 체크박스
   	const selectAll  = document.querySelector('input[name="selectall"]');
    	  
   	if(checkboxes.length === checked.length)  {
    	selectAll.checked = true;
    	}else {
    	    selectAll.checked = false;
    	}

    	}

    function selectAll(selectAll)  {
   		const checkboxes = document.getElementsByName('selectone');
    	checkboxes.forEach((checkbox) => {
    	  checkbox.checked = selectAll.checked
    	  })
    	}
    
    function cong(){
    	alert("회원가입 성공");
    	document.location.href="${contextPath }/member/userList.do";
    }
    
    
    </script>
</head>
<body>
<div class="container"> 
<h3 class="text-center">회원가입</h3>
<hr/>
<br>
  <form action="${contextPath }/member/joinMember.do" 
  	class="form-horizontal" method="post" onsubmit="return Validation();">

    <div class="col-md-4 offset-md-4" >
      <label for="inputId"><strong>아이디</strong></label>
      <input type="text" class="form-control" name="id" id="id" maxlength="12" placeholder="4~12자의 영문 대소문자 숫자로만 입력">
    </div>
    <p></p>
    <div class="col-md-4 offset-md-4">
      <label for="inputPassword"><strong>비밀번호</strong></label>
      <input type="password" class="form-control" name="pw" id="floatingPassword" placeholder="4~12자의 영문 대소문자 숫자로만 입력">
    </div>
    <p></p>
     <div class="col-md-4 offset-md-4">
      <label for="inputPasswordRe"><strong>비밀번호 확인</strong></label>
      <input type="password" class="form-control" id="floatingRePassword" placeholder="4~12자의 영문 대소문자 숫자로만 입력">
    </div>
    <p></p>
    <div class="col-md-4 offset-md-4">
      <label for="inputEmail"><strong>이메일</strong></label>
      <input type="text" class="form-control" name="email" id="email" placeholder="예)id@domain.com">
    <p></p>
    <div class="col-md-9 offset-md-4">
    	<label for="inputAddress"><strong>주소</strong></label>
    	<input type="text" class="form-control" name="address" id="address" placeholder="예)oo시 oo구"/>
    </div>
    <p></p>
    </div>
    <div class="col-md-4 offset-md-4">
      <label for="inputPhoneNumber"><strong>휴대전화번호</strong></label>
      <input type="text" class="form-control" name="phone" id="phoneNumber" placeholder="예)010-1234-6578">
    </div>
    <p></p>
 	<div class="col-md-4 offset-md-4">
		<input type="checkbox"  name="selectall" value="selectall" onclick="selectAll(this)" />
  		<label for="check_all">전체 동의</label>
  	</div>
  	<div class="col-md-4 offset-md-4">
 		 <input type="checkbox" name="selectone" value="select1" onclick="checkSelcetAll(this)" />
  		 <a href="#" target="_blank">개인정보 처리방침 동의</a>
  	</div>
	<div class="col-md-4 offset-md-4">
 		 <input type="checkbox" name="selectone" value="select2" onclick="checkSelectAll(this)" />
  	     <a href="#" target="_blank">서비스 이용약관 동의</a>
  	</div>
  	<div class="col-md-4 offset-md-4">
  		 <input type="checkbox" name="selectone" value="select3" onclick="checkSelectAll(this)" />
  	     <a href="#" target="_blank">마케팅 수신 동의</a>
  	</div>
  	<br>
<div class="row">
  <div id="aa1" class="col-md-2 offset-md-5" align="center">  
     <input class="btn btn-primary"  type="submit" value="가입하기" onClick="cong()">
	</div>
</div>
<br>
<div class="row">
<div id="aa1" class="col-md-2 offset-md-5" align="center">
	<input class="btn btn-danger"  name="submit" value="가입취소">
  </div>
</div>
</form>
</div> 
</body>
</html>
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
	<title>해외축구</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.container{
			padding-top:20px;
			padding-bottom:20px;
		}
		h3{
			text-align:center;
		}
		#a1{
			text-align:right;
		}
		.pagination{
			justify-content: center;
		}
		#search2{
			margin:auto;
			text-align:center;
		}
	</style>
</head>
<body>
	<div class="container">
		<h3>해외축구</h3>
		<hr/>
		<br>
		<nav class="navbar-expand">
			<ul class="navbar-nav">
				<li class="nav-item btn btn-sm btn-default"><a href="#">공지사항</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">모두보기</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">EPL</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">세리에</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">라리가</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">분데스리가</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">리그앙</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">기타리그</a>
			</ul>
		</nav>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
				
			</tr>
			<c:forEach var="osArticle" items="${allList }">
			<tr align="center" >
				<td>${osArticle.category}</td>
				<td>${osArticle.no }</td>
				<td><a href="${contextPath}/board/osView.do?no=${osArticle.no}">
					${osArticle.title }</a>
				</td>
				<td>${osArticle.regdate }</td>
				<td>${osArticle.u_id }</td>
				<td>${osArticle.view }</td>
				
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<p id="a1">
		<a id="a1" class="btn btn-primary" href="${contextPath }/board/osWriteForm.do">글쓰기</a>
		</p>
		<br>
		
		<div class="row">
		<div class="col-md-6" id="search2">
  			  <div class="input-group">
  			  	<select class="select">
  			  		<option>제목</option>
  			  		<option>작성자</option>
  			  		<option>제목+작성자</option>
  			  	</select>
  			    <input type="text" class="form-control" placeholder="내용을 입력하세요">
    			  <span class="input-group-btn">
       				 <button class="btn btn-default" type="button">검색</button>
    			  </span>
 			   </div><!-- /input-group -->
 		</div>
		</div>
		<br>
		<nav aria-label="Page navigation">
 			<ul class="pagination">
    			<li class="page-item">
      				<a class="page-link" href="#" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
        			<span class="sr-only">Previous</span>
      				</a>
    			</li>
    			<li class="page-item"><a class="page-link" href="#">1</a></li>
    			<li class="page-item"><a class="page-link" href="#">2</a></li>
    			<li class="page-item"><a class="page-link" href="#">3</a></li>
    			<li class="page-item"><a class="page-link" href="#">4</a></li>
    			<li class="page-item"><a class="page-link" href="#">5</a></li>
    			<li class="page-item">
      				<a class="page-link" href="#" aria-label="Next">
        			<span aria-hidden="true">&raquo;</span>
        			<span class="sr-only">Next</span>
      				</a>
    			</li>
  			</ul>
		</nav>
		
	</div>
</body>
</html>
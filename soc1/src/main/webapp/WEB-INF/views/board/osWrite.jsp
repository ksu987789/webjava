<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%
	String ctx = request.getContextPath();	//콘텍스트명 얻어오기.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SmartEditor</title>
<script type="text/javascript" src="<%=ctx %>/SE/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1",
          sSkinURI: "/aaaa/SE/SmartEditor2Skin.html",  
          htParams : {
              bUseToolbar : true,             
              bUseVerticalResizer : true,     
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              oEditors.getById["ir1"].exec("PASTE_HTML", ["내용을 입력해주세요"]);
          },
          fCreator: "createSEditor2"
      });
});


</script>
<style>
	.container{
		padding:2em;
	}
	table{
		padding-left:170px;
	}
	h3{
		text-align:center;
	}
	
	
</style>
</head>
<body>
<div class="container" align="right">
<h3>글쓰기</h3>
<hr/>
<form id="frm" action="insert.jsp" method="post" >
<table width="70%" align="center">
        <tr>
            <td>제목</td>
            <td><input type="text" id="title" name="title" style="width:650px"/></td>
        </tr>
        <tr>
        	<td>아이디</td>
        	<td><input class="col-md-2 form-control" type="text" placeholder="작성자1" readonly></td>

        	
        </tr>
        <tr>
        	<td>카테고리</td>
        	<td>
        	<select class="col-md-2 form-control" id="category" name="category">
  				<option>EPL</option>
  				<option>세리에</option>
  				<option>라리가</option>
  				<option>분데스리가</option>
  				<option>리그앙</option>
  				<option>기타리그</option>
			</select>
        	</td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea rows="10" cols="30" id="ir1" name="ir1" style="width:650px; height:350px; "></textarea>
            </td>
        </tr>
        <tr>
				<td align="right">첨부파일 : </td>
				<td><input type="file" name="imageFileName" onchange="readURL(this);" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="submit" value="글쓰기"  />
					<input type="button" value="취소"/>
				</td>
			</tr>
</table>
</form>
</div>
</body>
</html>
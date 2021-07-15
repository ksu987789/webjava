<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<style>
		#container {
			width:100%;
			margin:0px auto;
			text-align:center;
			
		}
		#header {
			padding:5px;
			margin-bottom:5px;
			
			
		}
		#content {
			width:100%;
			padding:5px;
			
		
			
		}
		#footer {
			clear:both;
			padding:5px;
			
			
		}
	</style>
	<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header"/>
		</div>
		<div id="content">
			<tiles:insertAttribute name="body"/>
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</body>

</html>
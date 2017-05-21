<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>details</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#panel-css").css({
				"margin-top":"20px",
				"width":"100%"
			});
			$("#add-life-day").css({
				"margin":"5px",
			});
			$("#add-life-day").click(function(){
				location.href="${pageContext.request.contextPath}/findAll";
			});
			$("#mood-assessment").css({
				"margin-bottom":"10px"
			})
		});
	</script>

</head>
<body>
	<div class="container"  align="center">
			<div  style="background-color:white;margin:20px 0px">
				<span><font style="font-size:22px">${dlist.get(0).title }</font></span>
			<div id="mood-assessment" align="left">
				心情分：<input type="text" name="mood" value="${dlist.get(0).mood}" readonly/>
			</div>
				<textarea class="form-control" cols="*" rows="20"  name="details" readonly style="font-size:15px;border:none;background-color:white">${dlist.get(0).details}</textarea>
				<button id="add-life-day" type="button" class="btn btn-primary">返回</button>
			</div>
	</div>
</body>
</html>
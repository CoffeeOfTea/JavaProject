<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Details</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#page-title").css({
					"margin-top":"20px"
				});
				$("#page-details").css({
					"margin-top":"20px",
					"margin-right":"20px",
					"padding-top":"5px",
					"padding-bottom":"5px",
					"padding-right":"10px",
					"padding-left":"15px",
					"height":"100%",
					"width":"100%",
					"word-wrap": "break-word"
				});
				$("#page-mood").css({
					"position":"relative",
					"margin-right":"400px",
					"margin-bottom":"10px"
				});
				$("#mood-assessment").css({
					"margin-bottom":"10px"
				})

			});
			
			function backClick(){
				location.href="${pageContext.request.contextPath}/findAll";
			}
		</script>
	</head>
	<body>
		<div class="container" style="border: 1px solid #999;">
			<form action="${pageContext.request.contextPath}/editDiary?id=${dlist.get(0).id}" method="post">
				<!--内容标题-->		
				<div class="page-header" align="center">
					<span>
						<font style="font-weight: bold; font-size:20px;">标题：</font>
						<input type="text" name="title" value="${dlist.get(0).title}"/>
					</span>
				</div>
				
				<!--内容详情展示-->
				<div>
					<!-- mood -->
					<div id="mood-assessment">
						心情分：<input type="text" name="mood" value="${dlist.get(0).mood}"/>
					</div>
					<textarea class="form-control" cols="100" rows="24" name="details">${dlist.get(0).details}</textarea>
				</div>
				
				
				<!-- 修改按钮 -->
				<div align="center">
					<input type="button" class="btn btn-default" value="返回" onclick="backClick()"/>
					<input type="submit" class="btn btn-default" name="edit" value="保存修改"/>
				</div>
			</form>
		</div>
		
	</body>
</html>

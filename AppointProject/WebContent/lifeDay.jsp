<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>a day in the life</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#mood-assessment").css({
					"margin-bottom":"10px"
				})
			});
		</script>
	</head>
	<body>
		
		<div class="container" style="border: 1px solid #999;">
			<form action="${pageContext.request.contextPath}/lifeDay" method="post">
				<!--标题-->
				<div class="page-header" align="center">
					<span>
						<font style="font-weight:bold;font-size:20px;">标题：</font>
						<input type="text" name="title" value="无" />
					</span>
				</div>
				
				<!--内容-->
				<div>
					<div class="form-group">
						<!--心情评估-->
						<div id="mood-assessment">
							心情评估：<input type="text" name="mood" value="" placeholder="如果满分是10分"/>
						</div>
						
						<textarea class="form-control" rows="20" name="details" placeholder="请输入......"></textarea>
					</div>
				</div>
	
				<!--提交按钮-->
				<div align="center">
					<input type="submit" class="btn btn-primary" value="提交"/>
				</div>
			</form>
		</div>
		
	</body>
</html>

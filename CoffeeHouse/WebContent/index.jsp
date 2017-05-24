<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
		
		function commit(url){
			if($("input[name=username]").val() != null &&
					$("input[name=password]").val() != null &&
					$("input[name=username]").val() != "" &&
					$("input[name=password]").val() != ""){
				var u = "${pageContext.request.contextPath}/user?"+url;
				document.form1.action = u;
				document.form1.submit();
			}
			else{
				alert("用户名或密码不能为空");
			}
		}
	</script>

	<title>Welcome</title>
</head>
<body>
	<div class="container" >
		<div style="width:300px;padding: 100px 50px 10px 10px;">
			<form name="form1" class="bs-example bs-example-form" method="post">
				<div class="input-group">
					<span class="input-group-addon" >用户名：</span>
					<input name="username" type="text" class="form-control">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
					<input name="password" type="text" class="form-control">
				</div>
				<br>
				<input class="btn btn-default" type="button" name="register" value="注册" onclick="commit('method=register')"/>
				<input class="btn btn-default" type="button" name="login" value="登陆" onclick="commit('method=login')"/>
				
			</form>
		</div>
	</div>
</body>
</html>
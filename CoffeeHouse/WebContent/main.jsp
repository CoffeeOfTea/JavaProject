<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			onshow();
			/* onlineDisplay(); */
		});
		function btn_send(){
			var str = $("textarea[name=info]").val();
			$.post("${pageContext.request.contextPath}/user?method=infoSend&str="+str,$("#form1").serialize(),function(data){
				$("#content").html(data);
				$("textarea[name=info]").val("");
			});
		}
		
		function onshow(){
			$.post("${pageContext.request.contextPath}/user?method=infoShow",$("#form1").serialize(),function(data){
				$("#content").html(data);
				setTimeout('onshow()', 4000);
			});
		}
		
	/* 	function onlineDisplay(){
			$.post("${pageContext.request.contextPath}/user?method=onlineDisplay",$("#form1").serialize(),function(data){
				$("#online").html(data);
				setTimeout('onlineDisplay()', 4000);
			}); 
		}*/
		
	</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="border: 1px solid #999;">
		<div>
<%-- 			<textarea class="form-control" cols="100" rows="1" name="oneSelf">${username }</textarea>
				<textarea id="online" class="form-control" cols="100" rows="1" name="online"></textarea>  --%>
				${username }
		</div>

	   <div id="context">
	   		<textarea id="content" readonly="readonly" class="form-control" cols="100" rows="24" name="record">
			</textarea>
			
		</div>
		<br>
		<div>
			<textarea class="form-control" cols="100" rows="2" name="info"></textarea>
			<input type="button" name="send" value="发送" onclick="btn_send()"/>
		</div>
	</div>
</body>
</html>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>RecordDay</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function() {
				/* $("div[class=panel-body]").css({
					"border": "1px solid #999"
				}); */
				$(".panel-body-basic").css({
					"width": "80%",
					"float": "left"
				});
				$(".panel-body-button").css({
					"width": "10%",
					"float": "left",
  					"margin-left":"5px"
				});
				$("#page-header-title").css({
					"width": "85%",
					"float": "left"
				});
				$(".panel-body-basic-display").css({
					//"border": "1px solid #999",
					"width":"100%",
					"height":"100%",
					"overflow":"hidden",
					"word-wrap": "break-word"
				});
				
				$("#add-life-day").click(function(){
					location.href="/AppointProject/lifeDay.jsp";
				});
				
				$(".panel-body-button-item").css({
					"margin-top":"15px",
					"margin-bottom":"5px"
				});
				$("#add-life-day").css({
					"margin-top":"10px",
					"margin-bottom":"5px",
					"margin-left":"5px"
				});
			});
			function editClick(id){
				location.href="${pageContext.request.contextPath}/details?id="+id;
			}
			function deleteClick(id){
				if(confirm("确认删除？")){
					location.href="${pageContext.request.contextPath}/deleteDiary?id="+id;
				}
			}
		</script>
		
		<style>
			a.a-details:link    {color:black;text-decoration: none;}
			a.a-details:visited {color:black;}
			a.a-details:hover   {color:black;}
			a.a-details:active  {color:black;}
		</style>
	</head>

	<body>
		<div class="container" style="border: 1px solid #999;">
			<!--
            	导航栏
            -->
            
			<ol class="breadcrumb">
				<li><a href="#">主页</a></li>
				<li><a href="#">2017(年份)</a></li>
				<li><a href="#">四月(月份)</a></li>
				<li class="active">24日(日期)</li>
			</ol>
			<!--
            	标题
            -->
  
			<div class="page-header">
				<div id="page-header-title">
    				<h1>
    					Diary every day<img src="images/P70430-142024.jpg" width="30px"height="30px">
   	 				</h1>
   	 			</div>
   	 			<!--添加按钮-->
					<button id="add-life-day" type="button" class="btn btn-primary">编写新一天</button>
					<span style="display:inline-block;margin:6px 4px">共有${pb.totalCount }条记录，${pb.totalPage }页</span>
			</div>
			<!--内容展示1-->
			<c:forEach items="${pb.list }" var="d">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">${d.title }</h3>
						${d.logdate }
					</div>
					<div class="panel-body">
						<div class="panel-body-basic col-lg-1 col-md-3 col-sm-6 col-xs-12">
							<div class="panel-body-basic-display" >
								<a class="a-details" href="${pageContext.request.contextPath }/details?id=${d.id }&by=1">
									<c:if test="${d.details.length()<50}">
										${d.details}
									</c:if>
									<c:if test="${d.details.length()>=50}">
										${d.details.substring(0,50)}......
									</c:if>
								</a> 
							</div>
						</div>
						<div class="panel-body-button">
							<div class="panel-body-button-item btn-group">
								<button type="button" class="btn btn-default" onclick="deleteClick(${d.id})"> 
									删除
								</button>
								<button type="button" class="btn btn-default" onclick="editClick(${d.id})"> 
									修改
								</button>
								
							</div>
						</div>
					</div>
				</div>	
			</c:forEach>
			<div align="center">
				<ul class="pagination">
				<c:if test="${pb.currPage != 1 }">
					<li><a href="${pageContext.request.contextPath }/findAll?currPage=1">&laquo;</a></li>	
					<li><a href="${pageContext.request.contextPath }/findAll?currPage=${pb.currPage-1}">&lsaquo;</a></li>
				</c:if>
				<c:if test="${pb.currPage == pb.totalPage }"><li><a href="${pageContext.request.contextPath }/findAll?currPage=${pb.totalPage-2}">${pb.totalPage-2 }</a></li></c:if>
				<c:forEach begin="${pb.currPage-1>0 ? pb.currPage-1 : 1 }" end="${pb.totalPage-pb.currPage>1 ? pb.currPage+1 : pb.totalPage }" var="n">
					<c:if test="${pb.currPage == n }"><li class="active"><a href="${pageContext.request.contextPath }/findAll?currPage=${n}">${n }</a></li></c:if>
					<c:if test="${pb.currPage != n }"><li><a href="${pageContext.request.contextPath }/findAll?currPage=${n}">${n }</a></li></c:if>
				</c:forEach>
				<c:if test="${pb.currPage == 1 }"><li><a href="${pageContext.request.contextPath }/findAll?currPage=3">3</a></li></c:if>
				<c:if test="${pb.currPage != pb.totalPage }">
					<li><a href="${pageContext.request.contextPath }/findAll?currPage=${pb.currPage+1}">&rsaquo;</a></li>
					<li><a href="${pageContext.request.contextPath }/findAll?currPage=${pb.totalPage}">&raquo;</a></li>
				</c:if>
				</ul>
			</div>
		</div>
	</body>

</html>
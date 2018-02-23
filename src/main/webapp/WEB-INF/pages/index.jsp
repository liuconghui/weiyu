<%--
  Created by IntelliJ IDEA.
  User: panzhichao
  Date: 2017/12/6
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>络宏后台管理系统</title>
    <script type="text/javascript" src="../../js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="../../js/jquery-form.js"></script>
	<script type="text/javascript" src="../../js/echarts.min.js"></script>
    <style type="text/css">
		<!--
		#content{width:70%;height:100%;float:left}
		#left{width:20%;height:100%;float:left}
		#content ul{ list-style:none; padding:0px; margin:0px; width:100%;
		height:20px; line-height:20px; border:0px solid #99CC00;
		border-top:1px solid #99CC00; font-size:12px;}
		#content ul li{ display:block; width:10%; float:left;border:0px solid #99CC00;text-indent:2em;height:20px;}
		-->
	</style>
</head>
<body>
<div id="head"></div>
<div id="left"></div>
<div id="content"></div>
<div id="foot"></div>
<script>
 	$(document).ready(function(){
 		$("#left").load("left.do");
 	});
 	
 	function changee(num){
			if(num=="a11"){
				$("#content").load("devicetype.do");
			}else if(num=="a12"){
				$("#content").load("device.do");
			}else if(num=="a13"){
				$("#content").load("stock.do");
			}else if(num=="a21"){
				$("#content").load("module.do");
			}else if(num=="a22"){
				$("#content").load("role.do");
			}else if(num=="a23"){
				$("#content").load("employee.do");
			}else if(num=="a24"){
				$("#content").load("repository.do");
			}else if(num=="a25"){
				$("#content").load("area.do");
			}else if(num=="a26"){
				$("#content").load("workorder.do");
			}else if(num=="a31"){
				$("#content").load("tangkou.do");
			}else if(num=="a32"){
				$("#content").load("configuration.do");
			}else if(num=="a33"){
				$("#content").load("advert.do");
			}else if(num=="a34"){
				$("#content").load("notice.do");
			}else if(num=="a35"){
				$("#content").load("feedback.do");
			}else if(num=="a36"){
				$("#content").load("member.do");
			}else if(num=="a41"){
				$("#content").load("monitor.do");
			}else if(num=="a42"){
				$("#content").load("log.do");
			}else if(num=="a43"){
				$("#content").load("charmonitor.do");
			}else if(num=="a51"){
				$("#content").load("");
			}
			else if(num=="a52"){
				$("#content").load("");
			}
		};
</script>

</body>
</html>

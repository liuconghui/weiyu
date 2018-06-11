<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<ul>
		<li>会员名称</li>
		<li>塘口名称</li>
		<li>溶氧异常情况</li>
		<li>温度情况</li>
		<li>设备情况</li>
		<li>操作</li>
	</ul>
	<ul>
		<li>张三</li>
		<li>张三一号塘</li>
		<li>正常</li>
		<li>正常</li>
		<li>正常</li>
		<li><span onclick="details()">详情</span></li>
	</ul>
	<script>
		function details(){
		    $("#querycontent").load("monitorquerydetails.do");
		}
		
	</script>
</div>
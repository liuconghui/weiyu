<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<div>
	<p>广告管理</p>
	<p>
		<span id="add">新增 </span>
		<span id="query"> 查询</span>
		<span id="adsenseadd"> 新增广告位 </span>
		<span id="adsensequery"> 查询广告位 </span>
	</p>
	</div>
	<div id="querycontent"></div>
	<script>
		$("#query").click(function(){
			$("#querycontent").load("advertquery.do");
		});
		
		$("#adsensequery").click(function(){
			$("#querycontent").load("adsensequery.do");
		});
		
	</script>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<div>
	<p>通知管理</p>
	<p>
		<span id="query"> 新增</span>
		<span id="query"> 查询</span>
	</p>
	</div>
	<div id="querycontent"></div>
	<script>
		$("#query").click(function(){
			$("#querycontent").load("noticequery.do");
		});
		
	</script>
</div>
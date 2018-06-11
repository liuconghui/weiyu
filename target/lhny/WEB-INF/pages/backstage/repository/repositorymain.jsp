<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<div>
	<p>知识库管理</p>
	<p><span id="add">新增 </span><span id="query"> 查询</span></p>
	</div>
	<div id="querycontent">规划中</div>
	<script>
		$("#query").click(function(){
			//$("#querycontent").load("repositoryquery.htm");
		});
	</script>
</div>
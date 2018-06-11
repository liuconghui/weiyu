<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="formstyle">
	<ul>
		<li>模块名称</li>
		<li>url</li>
		<li>父模块</li>
		<li>最后修改时间</li>
		<li>修改人</li>
		<li>操作</li>
	</ul>
	<c:forEach items="${modulelist}" var="list">
		<ul>
			<li>${list.name}</li>
			<li>${list.url}</li>
			<li>${list.fname}</li>
			<li>${list.whsj}</li>
			<li>${list.whr}</li>
			<li><span onclick="modulemodify('${list.id}','${list.name}','${list.url}','${list.fid}','${list.fname}')">修改</span></li>
		</ul>
	</c:forEach>
</div>
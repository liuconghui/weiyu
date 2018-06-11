<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="formstyle">
	<ul>
		<li>员工编号</li>
		<li>员工名称</li>
		<li>联系号码</li>
		<li>入职时间</li>
		<li>功能角色</li>
		<li>最后修改时间</li>
		<li>修改人</li>
		<li>操作</li>
	</ul>
	<ul>
		<c:forEach items="${employeelist}" var="list">
			<ul>
				<li>${list.empno}</li>
				<li>${list.name}</li>
				<li>${list.phone}</li>
				<li>${list.hiredate}</li>
				<li>${list.role}</li>
				<li>${list.uptime}</li>
				<li>admin</li>
				<li><span>修改</span><span onclick="delete(${list.empno})">删除</span><span>密码初始化</span></li>
			</ul>
		</c:forEach>
	</ul>
	
</div>
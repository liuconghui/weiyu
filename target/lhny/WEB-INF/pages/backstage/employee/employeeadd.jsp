<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
		<!-- 添加员工 -->
		<div id="addShade">
			<div>
				<div>增加人员</div>
				<div>
					<form id="addForm" method="post" action="employeeaddsave.do">
						<div>
							<label>姓名:</label>
						<span>
							<input type="text" name="name" id="name">
							<p id="p_name" style="display: inline"></p>
						</span>
						</div>
						<div>
							<label>电话:</label>
						<span>
							<input type="text" name="phone" id="phone">
							<p id="p_phone" style="display: inline"></p>
						</span>
						</div>
						<div>
							<label>功能角色:</label>
						<span>
							<select id="single" name="role">
							</select>
						</span>
						</div>
						<div>
							<label>入职日期:</label>
						<span>
							<input type="text" name="hiredate" id="hiredate">
							<p id="p_hiredate" style="display: inline"></p>
						</span>
						<div class="btns">
							<input type="button" data-title="submit" value="保存" onclick="javascript:putOn();"/>
							<input  type="button" value="取消" onclick="del()">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="../js/employee.js"></script>
<script>
	function del() {
		var msg = "您真的确定要取消吗！";
		if (confirm(msg)==true){
			location.href = 'pages/backstage/employee/employeemain';
		}else{
			location.href = 'pre.jsp';
		}
	}
</script>
</div>